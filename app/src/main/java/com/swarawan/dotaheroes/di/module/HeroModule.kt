package com.swarawan.dotaheroes.di.module

import android.content.Context
import com.swarawan.dotaheroes.data.data.repository.DotaHeroesRepository
import com.swarawan.dotaheroes.di.AppContext
import com.swarawan.dotaheroes.presentation.heroes.Hero
import com.swarawan.dotaheroes.presentation.heroes.HeroAdapter
import com.swarawan.dotaheroes.presentation.heroes.HeroPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by rioswarawan on 12/24/17.
 */

@Module
class HeroModule {

    @Provides
    @Singleton
    fun provideHeroList(): MutableList<Hero> = ArrayList()

    @Provides
    @Singleton
    fun provideHeroAdapter(@AppContext context: Context, heroes: List<Hero>): HeroAdapter = HeroAdapter(context, heroes)

    @Provides
    @Singleton
    fun provideHeroPresenter(dotaHeroesRepository: DotaHeroesRepository): HeroPresenter = HeroPresenter(dotaHeroesRepository)
}