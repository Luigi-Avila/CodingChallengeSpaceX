package com.example.codingchallengespacex

import android.app.Application
import com.example.codingchallengespacex.core.di.networkModule
import com.example.codingchallengespacex.core.di.repositoryModule
import com.example.codingchallengespacex.core.di.serviceModule
import com.example.codingchallengespacex.core.di.useCaseModule
import com.example.codingchallengespacex.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

class SpaceXApplication : Application() {
    override fun onCreate() {
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
                useCaseModule
            )
        }
    }
}