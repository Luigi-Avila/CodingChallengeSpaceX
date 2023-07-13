package com.example.codingchallengespacex

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SpaceXApplication : Application() {
    /*override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@SpaceXApplication)
            // Load modules
            modules(
                networkModule,
                repositoryModule,
                serviceModule,
                viewModelModule,
                useCaseModule,
                imageModule
            )
        }
    }*/
}