package com.example.draftassessment.domain.usecase

import com.example.draftassessment.domain.model.Team
import com.example.draftassessment.domain.repository.SportsRepository

class GetTeamsForLeagueUseCase(private val repository: SportsRepository) {
    suspend operator fun invoke(leagueName: String): Result<List<Team>> {
        return repository.getTeamsForLeague(leagueName)
    }
}