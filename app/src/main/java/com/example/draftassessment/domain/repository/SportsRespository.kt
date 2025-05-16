package com.example.draftassessment.domain.repository

import com.example.draftassessment.domain.model.League
import com.example.draftassessment.domain.model.Team

interface SportsRepository {
    suspend fun getAllLeagues(): Result<List<League>>
    suspend fun getTeamsForLeague(leagueName: String): Result<List<Team>>
}