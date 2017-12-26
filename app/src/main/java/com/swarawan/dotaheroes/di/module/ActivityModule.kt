package com.swarawan.dotaheroes.di.module

import android.app.Activity
import android.content.Context
import com.swarawan.dotaheroes.di.PerActivitiy
import dagger.Module
import dagger.Provides

/**
 * Created by rioswarawan on 12/24/17.
 */

@Module
class ActivityModule(val activity: Activity) {

    @Provides
    @PerActivitiy
    fun provideActivityContext(): Context = activity
}