package com.example.educationalproject

import android.app.Application
import com.example.educationalproject.di.AppComponent
import com.example.educationalproject.di.DaggerAppComponent

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        dagger = DaggerAppComponent.create()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}