package com.codingwithmitch.bottomnavigationmultiplebackstacks.di

import android.app.Application
import com.codingwithmitch.bottomnavigationmultiplebackstacks.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(mainActivity: MainActivity)
}