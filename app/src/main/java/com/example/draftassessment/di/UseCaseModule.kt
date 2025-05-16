package com.example.draftassessment.di

import com.example.draftassessment.domain.repository.SportsRepository
import com.example.draftassessment.domain.usecase.GetLeaguesUseCase
import com.example.draftassessment.domain.usecase.GetTeamsForLeagueUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetLeaguesUseCase(repository: SportsRepository): GetLeaguesUseCase {
        return GetLeaguesUseCase(repository)
    }

    @Provides
    fun provideGetTeamsForLeagueUseCase(repository: SportsRepository): GetTeamsForLeagueUseCase {
        return GetTeamsForLeagueUseCase(repository)
    }
}