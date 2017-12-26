package com.swarawan.dotaheroes.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.swarawan.dotaheroes.App
import com.swarawan.dotaheroes.di.component.ActivityComponent

/**
 * Created by rioswarawan on 12/24/17.
 */
abstract class InjectedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inject(App.get(this).createActivityComponent(this))
    }

    abstract fun inject(activityComponent: ActivityComponent)

}