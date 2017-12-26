package com.swarawan.dotaheroes.data.data.repository

import com.swarawan.dotaheroes.presentation.heroes.Hero
import io.reactivex.Observable

/**
 * Created by rioswarawan on 12/23/17.
 */
interface DotaHeroesRepository {

    fun getDotaHeroes() : Observable<List<Hero>>
}