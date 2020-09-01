package com.tobidaada.loanapplication

import android.app.Application
import com.cyberspace.cyberpaysdk.CyberpaySdk
import com.cyberspace.cyberpaysdk.enums.Mode
import com.tobidaada.loanapplication.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        val modules = listOf(repositoryModule, networkModule, domainModule, presentationModule)

        startKoin {
            androidContext(this@App)
            modules(modules)
        }

        // Configure CyberSpace SDK
        CyberpaySdk.initialiseSdk(BuildConfig.INTEGRATION_KEY, Mode.Debug)
    }
}