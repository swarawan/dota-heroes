package com.swarawan.dotaheroes

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.swarawan.dotaheroes.di.component.ActivityComponent
import com.swarawan.dotaheroes.di.component.AppComponent
import com.swarawan.dotaheroes.di.component.DaggerAppComponent
import com.swarawan.dotaheroes.di.module.ActivityModule
import com.swarawan.dotaheroes.di.module.AppModule
import com.swarawan.dotaheroes.di.module.DataModule
import timber.log.Timber

/**
 * Created by rioswarawan on 12/22/17.
 */
class App : Application() {

    companion object {
        fun get(context: Context): App = context.applicationContext as App
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .dataModule(DataModule())
                .build()
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    fun createActivityComponent(activity: AppCompatActivity): ActivityComponent {
        return appComponent
                .activityComponen()
                .plus(ActivityModule(activity))
                .build()
    }
}