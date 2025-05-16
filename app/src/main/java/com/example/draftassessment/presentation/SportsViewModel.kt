package com.example.draftassessment.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.draftassessment.domain.model.League
import com.example.draftassessment.domain.model.Team
import com.example.draftassessment.domain.usecase.GetLeaguesUseCase
import com.example.draftassessment.domain.usecase.GetTeamsForLeagueUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SportsViewModel @Inject constructor(
    private val getLeaguesUseCase: GetLeaguesUseCase,
    private val getTeamsForLeagueUseCase: GetTeamsForLeagueUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(SportsUiState())
    val uiState: StateFlow<SportsUiState> = _uiState.asStateFlow()

    init {
        loadLeagues()
    }

    fun loadLeagues() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            getLeaguesUseCase().fold(
                onSuccess = { leagues ->
                    _uiState.update {
                        it.copy(
                            leagues = leagues,
                            isLoading = false,
                            error = null
                        )
                    }
                },
                onFailure = { error ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = error.message ?: "Unknown error occurred"
                        )
                    }
                }
            )
        }
    }

    fun selectLeague(league: League) {
        val isAlreadySelected = _uiState.value.selectedLeague?.id == league.id

        if (isAlreadySelected) {
            // Deselect if already selected
            _uiState.update {
                it.copy(
                    selectedLeague = null,
                    teams = emptyList(),
                    isLoadingTeams = false
                )
            }
        } else {
            // Select new league and load its teams
            _uiState.update {
                it.copy(
                    selectedLeague = league,
                    teams = emptyList(),
                    isLoadingTeams = true
                )
            }

            loadTeamsForLeague(league.name)
        }
    }

    private fun loadTeamsForLeague(leagueName: String) {
        viewModelScope.launch {
            getTeamsForLeagueUseCase(leagueName).fold(
                onSuccess = { teams ->
                    _uiState.update {
                        it.copy(
                            teams = teams,
                            isLoadingTeams = false,
                            error = null
                        )
                    }
                },
                onFailure = { error ->
                    _uiState.update {
                        it.copy(
                            isLoadingTeams = false,
                            error = error.message ?: "Failed to load teams"
                        )
                    }
                }
            )
        }
    }
}

data class SportsUiState(
    val leagues: List<League> = emptyList(),
    val selectedLeague: League? = null,
    val teams: List<Team> = emptyList(),
    val isLoading: Boolean = false,
    val isLoadingTeams: Boolean = false,
    val error: String? = null
)