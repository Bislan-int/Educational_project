package com.example.educationalproject.di.modules

import android.content.Context
import com.example.educationalproject.data.MainRepository
import com.example.educationalproject.data.TmdbApi
import com.example.educationalproject.data.preferenes.PreferenceProvider
import com.example.educationalproject.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule(val context: Context) {
    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    fun providePreferences(context: Context) = PreferenceProvider(context)

    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi, preferenceProvider: PreferenceProvider) =
        Interactor(repo = repository, retrofitService = tmdbApi, preferences = preferenceProvider)
}