package com.example.TaskListKotlin

import android.app.Application
import com.example.TaskListKotlin.di.Dependencies

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Dependencies.init(applicationContext)
    }
}