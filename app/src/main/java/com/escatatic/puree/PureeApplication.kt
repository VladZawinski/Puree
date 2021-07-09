package com.escatatic.puree

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.uniflow.core.logger.UniFlowLogger
import timber.log.Timber

@HiltAndroidApp
class PureeApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}