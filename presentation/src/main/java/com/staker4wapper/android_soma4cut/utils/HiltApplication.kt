package com.staker4wapper.android_soma4cut.utils

import android.app.Application
import com.staker4wapper.data.utils.PreferenceManager
import dagger.hilt.android.HiltAndroidApp
@HiltAndroidApp
class HiltApplication : Application() {

    companion object {
        lateinit var prefs: PreferenceManager
    }

    override fun onCreate() {
        prefs = PreferenceManager(applicationContext)
        super.onCreate()
    }
}