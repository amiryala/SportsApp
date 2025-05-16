package com.example.draftassessment.domain.repository

import com.example.draftassessment.data.remote.SportsApiService
import com.example.draftassessment.data.remote.model.LeagueDto
import com.example.draftassessment.data.remote.model.TeamDto
import com.example.draftassessment.domain.model.League
import com.example.draftassessment.domain.model.Team
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SportsRepositoryImpl(
    private val apiService: SportsApiService
) : SportsRepository {

    override suspend fun getAllLeagues(): Result<List<League>> = withContext(Dispatchers.IO) {
        try {
            val response = apiService.getAllLeagues()
            Result.success(response.leagues.map { it.toDomain() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getTeamsForLeague(leagueName: String): Result<List<Team>> = withContext(Dispatchers.IO) {
        try {
            val response = apiService.getTeamsForLeague(leagueName)
            val teams = response.teams ?: emptyList()
            Result.success(teams.map { it.toDomain() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun LeagueDto.toDomain() = League(
        id = idLeague,
        name = strLeague
    )

    private fun TeamDto.toDomain() = Team(
        name = strTeam
    )
}