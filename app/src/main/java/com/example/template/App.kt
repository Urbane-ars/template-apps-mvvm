package com.example.template

import android.app.Application
import com.example.template.di.AppComponent
import com.example.template.di.DaggerAppComponent
import com.example.template.di.StorageModule

class App : Application() {
    var appComponent: AppComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
                .builder()
                .storageModule(StorageModule(this))
                .build()
    }
}