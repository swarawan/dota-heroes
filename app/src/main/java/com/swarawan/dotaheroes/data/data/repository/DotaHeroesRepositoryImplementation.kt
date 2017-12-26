package com.swarawan.dotaheroes.data.data.repository

import com.swarawan.dotaheroes.BuildConfig
import com.swarawan.dotaheroes.data.data.DotaService
import com.swarawan.dotaheroes.presentation.heroes.Hero
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by rioswarawan on 12/23/17.
 */
class DotaHeroesRepositoryImplementation @Inject constructor(val service: DotaService) : DotaHeroesRepository {

    override fun getDotaHeroes(): Observable<List<Hero>> {
        return service.getHeroStat()
                .flatMap { Observable.fromIterable(it) }
                .map {
                    Hero(id = it.id,
                            name = it.localizedName,
                            primaryAttribute = it.primaryAttr,
                            attackType = it.attackType,
                            roles = it.roles.toString(),
                            image = "${BuildConfig.OPENDOTA_API_URL}${it.image}",
                            health = "${it.baseHealth} (${it.baseHealthRegen})",
                            mana = "${it.baseMana} (${it.baseManaRegen})",
                            armor = it.baseArmor.toString(),
                            attack = "${it.baseAttackMin} - ${it.baseAttackMax}",
                            str = "${it.baseStr} (${it.strGain})",
                            agi = "${it.baseAgi} (${it.agiGain})",
                            int = "${it.baseInt} (${it.intGain})",
                            attackRange = it.attackRange.toString(),
                            moveSpeed = it.moveSpeed.toString(),
                            turnRate = it.turnRate.toString(),
                            cmEnable = it.cmEnabled)
                }
                .toList()
                .toObservable()
    }
}