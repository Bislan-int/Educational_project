package com.example.educationalproject.di

import com.example.educationalproject.di.modules.DatabaseModule
import com.example.educationalproject.di.modules.DomainModule
import com.example.educationalproject.di.modules.RemoteModule
import com.example.educationalproject.viewmodel.HomeFragmentViewModel
import com.example.educationalproject.viewmodel.SettingsFragmentViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RemoteModule::class,
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
    fun inject(settingsFragmentViewModel: SettingsFragmentViewModel)
}