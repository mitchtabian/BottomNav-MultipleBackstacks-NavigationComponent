package com.codingwithmitch.bottomnavigationmultiplebackstacks

import android.app.Application
import com.codingwithmitch.bottomnavigationmultiplebackstacks.di.AppComponent
import com.codingwithmitch.bottomnavigationmultiplebackstacks.di.DaggerAppComponent

class BaseApplication : Application(){

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
    }

    fun initAppComponent(){
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}