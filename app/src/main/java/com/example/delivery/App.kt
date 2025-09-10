package com.example.delivery

import android.app.Application
import com.example.delivery.dao.di.daoModule
import com.example.delivery.ui.viewmodel.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(viewModelModule, daoModule)
        }
    }
}