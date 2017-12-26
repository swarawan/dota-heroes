package com.swarawan.dotaheroes.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.swarawan.dotaheroes.db.dao.HeroDao
import com.swarawan.dotaheroes.db.entity.HeroEntity

/**
 * Created by rioswarawan on 12/26/17.
 */

@Database(entities = arrayOf(HeroEntity::class), version = 1)
abstract class AppDatabase(val heroDao: HeroDao) : RoomDatabase()