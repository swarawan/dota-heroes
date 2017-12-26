package com.swarawan.dotaheroes.presentation.heroes

import com.github.ajalt.timberkt.d
import com.github.ajalt.timberkt.e
import com.swarawan.dotaheroes.base.BasePresenter
import com.swarawan.dotaheroes.data.data.repository.DotaHeroesRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by rioswarawan on 12/24/17.
 */
class HeroPresenter @Inject constructor(private val repo: DotaHeroesRepository) : BasePresenter<HeroView>() {

    fun getHeroes() {
        view?.showLoading()
        compositeDisposable.add(repo.getDotaHeroes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    d { "success fetched heroes" }
                    view?.displayHero(result)
                    view?.hideLoading()
                }, { error ->
                    view?.hideLoading()
                    e { "error: ${error.localizedMessage}" }
                }))
    }

    fun searchHero(query: String) {

    }
}