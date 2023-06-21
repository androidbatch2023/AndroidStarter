package com.starter.app.di

import android.app.Application
import com.starter.app.di.component.ApplicationComponent
import com.starter.app.di.component.DaggerApplicationComponent

enum class Injector private constructor() {
    INSTANCE;

    lateinit var applicationComponent: ApplicationComponent
        internal set

    fun initAppComponent(application: Application, apiKey: String) {
        applicationComponent = DaggerApplicationComponent.builder()
                .application(application)
                .apiKey(apiKey)
                .build()
    }
}
