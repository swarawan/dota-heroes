package com.swarawan.dotaheroes.data.data

import com.swarawan.dotaheroes.data.data.model.HeroModel
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by rioswarawan on 12/23/17.
 */
interface DotaService {

    @GET("/api/heroStats")
    fun getHeroStat() : Observable<List<HeroModel>>
}