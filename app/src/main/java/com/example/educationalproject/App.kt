package com.example.educationalproject

import android.app.Application
import com.example.educationalproject.di.AppComponent
import com.example.educationalproject.di.DaggerAppComponent
import com.example.educationalproject.di.modules.DatabaseModule
import com.example.educationalproject.di.modules.DomainModule
import com.example.educationalproject.di.modules.RemoteModule

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        dagger = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}