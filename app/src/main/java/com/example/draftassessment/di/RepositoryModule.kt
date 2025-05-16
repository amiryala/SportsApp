package com.example.draftassessment.di

import com.example.draftassessment.data.remote.SportsApiService
import com.example.draftassessment.domain.repository.SportsRepository
import com.example.draftassessment.domain.repository.SportsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideSportsRepository(apiService: SportsApiService): SportsRepository {
        return SportsRepositoryImpl(apiService)
    }
}