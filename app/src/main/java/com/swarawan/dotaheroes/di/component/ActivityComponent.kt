package com.swarawan.dotaheroes.di.component

import com.swarawan.dotaheroes.di.PerActivitiy
import com.swarawan.dotaheroes.di.module.ActivityModule
import com.swarawan.dotaheroes.presentation.heroes.HeroesActivity
import dagger.Subcomponent

/**
 * Created by rioswarawan on 12/24/17.
 */

@PerActivitiy
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    @Subcomponent.Builder
    interface Builder {
        fun plus(activityModule: ActivityModule): Builder
        fun build(): ActivityComponent
    }

    fun inject(activity: HeroesActivity)
}