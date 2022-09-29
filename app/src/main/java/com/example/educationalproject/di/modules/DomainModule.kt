package com.example.educationalproject.di.modules

import com.example.educationalproject.data.MainRepository
import com.example.educationalproject.data.TmdbApi
import com.example.educationalproject.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi) = Interactor(repo = repository, retrofitService = tmdbApi)
}