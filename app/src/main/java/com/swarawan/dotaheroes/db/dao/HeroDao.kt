package com.swarawan.dotaheroes.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
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

    @Query("SELECT *FROM hero LIKE '%:query%'")
    fun search(query: String) : List<HeroEntity>
}