package com.example.draftassessment.domain.usecase

import com.example.draftassessment.domain.model.League
import com.example.draftassessment.domain.repository.SportsRepository

class GetLeaguesUseCase(private val repository: SportsRepository) {
    suspend operator fun invoke(): Result<List<League>> {
        return repository.getAllLeagues()
    }
}