package com.example.template.di

import com.example.template.ui.FirstActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(firstActivity: FirstActivity)
}