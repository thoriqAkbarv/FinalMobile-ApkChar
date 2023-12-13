package com.D121211024.apkcharacter

import android.app.Application
import com.D121211024.apkcharacter.data.AppContainer
import com.D121211024.apkcharacter.data.DefaultAppContainer

class MyApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}