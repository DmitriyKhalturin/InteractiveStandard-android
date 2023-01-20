package com.interactivestandard.android.component

import android.app.Application
import com.interactivestandard.android.di.koinModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 18.01.2023 23:51.
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MainApplication)

            modules(koinModule)
        }
    }

    override fun onLowMemory() {
        super.onLowMemory()

        // TODO: clear resources here.
    }
}
