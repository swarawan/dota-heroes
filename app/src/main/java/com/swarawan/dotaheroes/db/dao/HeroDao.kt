package com.swarawan.dotaheroes.db.dao

import android.arch.persistence.room.*
import com.swarawan.dotaheroes.db.entity.HeroEntity

/**
 * Created by rioswarawan on 12/26/17.
 */

@Dao
interface HeroDao {

    @Query("SELECT * FROM hero")
    fun loadAllHeroes(): List<HeroEntity>

    @Query("SELECT * FROM hero WHERE id = :heroId")
    fun loadHero(heroId: Number): HeroEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(heroes: List<HeroEntity>)

    @Update
    fun update(hero: HeroEntity)

    @Delete
    fun delete(hero: HeroEntity)

    @Query("SELECT *FROM hero LIKE '%:query%'")
    fun search(query: String): List<HeroEntity>
}