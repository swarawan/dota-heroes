package com.swarawan.dotaheroes.presentation.heroes

import com.swarawan.dotaheroes.base.BaseView

/**
 * Created by rioswarawan on 12/24/17.
 */
interface HeroView : BaseView{
    fun displayHero(fetchedHeroes: List<Hero>)
}