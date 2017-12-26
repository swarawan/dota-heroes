package com.swarawan.dotaheroes.di.component

import com.swarawan.dotaheroes.di.module.ActivityModule
import com.swarawan.dotaheroes.di.module.AppModule
import com.swarawan.dotaheroes.di.module.DataModule
import com.swarawan.dotaheroes.di.module.HeroModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by rioswarawan on 12/24/17.
 */

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        DataModule::class,
        HeroModule::class))
interface AppComponent {

    fun activityComponen(): ActivityComponent.Builder
}