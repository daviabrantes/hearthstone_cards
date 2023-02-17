package com.daviabrantes.hearthstone

import android.app.Application
import com.daviabrantes.hearthstone.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HearthstoneApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HearthstoneApplication)
            modules(networkModule)
        }
    }
}