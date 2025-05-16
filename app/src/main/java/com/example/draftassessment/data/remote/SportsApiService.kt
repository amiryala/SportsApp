package com.example.draftassessment.data.remote

import com.example.draftassessment.data.remote.model.LeaguesDto
import com.example.draftassessment.data.remote.model.TeamsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SportsApiService {
    @GET("all_leagues.php")
    suspend fun getAllLeagues(): LeaguesDto

    @GET("search_all_teams.php")
    suspend fun getTeamsForLeague(
        @Query("l") leagueString: String
    ): TeamsDto
}