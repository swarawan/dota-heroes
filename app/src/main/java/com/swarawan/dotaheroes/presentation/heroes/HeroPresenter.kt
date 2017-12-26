package com.swarawan.dotaheroes.presentation.heroes

import com.github.ajalt.timberkt.d
import com.github.ajalt.timberkt.e
import com.swarawan.dotaheroes.BuildConfig
import com.swarawan.dotaheroes.base.BasePresenter
import com.swarawan.dotaheroes.data.data.repository.DotaHeroesRepository
import com.swarawan.dotaheroes.db.AppDatabase
import com.swarawan.dotaheroes.db.entity.HeroEntity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by rioswarawan on 12/24/17.
 */
class HeroPresenter @Inject constructor(private val repo: DotaHeroesRepository, private val db: AppDatabase) : BasePresenter<HeroView>() {

    fun getHeroes() {
        view?.showLoading()
        compositeDisposable.add(repo.getDotaHeroes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { result ->
                    d { "ready to display" }
                    view?.displayHero(result)
                    return@map result
                }
                .flatMap { Observable.fromIterable(it) }
                .map {
                    d { "store data to database" }
                    HeroEntity(id = it.id,
                            name = it.name,
                            primaryAttr = it.primaryAttribute,
                            attackType = it.attackType,
                            roles = it.roles,
                            image = it.image,
                            health = it.health,
                            mana = it.mana,
                            baseArmor = it.armor,
                            attack = it.attack,
                            str = it.str,
                            agi = it.agi,
                            int = it.int,
                            attackRange = it.attackRange,
                            moveSpeed = it.moveSpeed,
                            turnRate = it.turnRate,
                            cmEnabled = it.cmEnable)
                }.toList()
                .map {
                    db.heroDao().insert(it)
                }
                .subscribe({
                    d { "done fetching and storing" }
                    view?.hideLoading()
                }, { error ->
                    view?.hideLoading()
                    e { "error: ${error.localizedMessage}" }
                }))
    }

    fun getHeroesLocal() {
        compositeDisposable.add(Observable.just(db.heroDao().loadAllHeroes())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { Observable.fromIterable(it) }
                .map {
                    Hero(id = it.id,
                            name = it.name,
                            primaryAttribute = it.primaryAttr,
                            attackType = it.attackType,
                            roles = it.roles,
                            image = it.image,
                            health = it.health,
                            mana = it.mana,
                            armor = it.baseArmor,
                            attack = it.attack,
                            str = it.str,
                            agi = it.agi,
                            int = it.int,
                            attackRange = it.attackRange,
                            moveSpeed = it.moveSpeed,
                            turnRate = it.turnRate,
                            cmEnable = it.cmEnabled)
                }.toList()
                .subscribe({ result ->
                    d { "display all heroes" }
                    view?.displayHero(result)
                    view?.hideLoading()
                }, { error ->
                    view?.hideLoading()
                    e { "error: ${error.localizedMessage}" }
                }))
    }

    fun searchHero(query: String) {
        view?.showLoading()
        val likeParam = "%$query%"
        compositeDisposable.add(Observable.just(db.heroDao().search(likeParam))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { Observable.fromIterable(it) }
                .map {
                    Hero(id = it.id,
                            name = it.name,
                            primaryAttribute = it.primaryAttr,
                            attackType = it.attackType,
                            roles = it.roles,
                            image = it.image,
                            health = it.health,
                            mana = it.mana,
                            armor = it.baseArmor,
                            attack = it.attack,
                            str = it.str,
                            agi = it.agi,
                            int = it.int,
                            attackRange = it.attackRange,
                            moveSpeed = it.moveSpeed,
                            turnRate = it.turnRate,
                            cmEnable = it.cmEnabled)
                }.toList()
                .subscribe({ result ->
                    d { "display search result" }
                    view?.displayHero(result)
                    view?.hideLoading()
                }, { error ->
                    view?.hideLoading()
                    e { "error: ${error.localizedMessage}" }
                }))
    }
}