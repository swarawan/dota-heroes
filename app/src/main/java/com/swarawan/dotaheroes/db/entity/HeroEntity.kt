package com.swarawan.dotaheroes.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by rioswarawan on 12/26/17.
 */

@Entity(tableName = "Hero")
data class HeroEntity(@PrimaryKey var id: Long = 0,
                      @ColumnInfo(name = "name") var name: String = "",
                      @ColumnInfo(name = "primary_attr") var primaryAttr: String = "",
                      @ColumnInfo(name = "attack_type") var attackType: String = "",
                      @ColumnInfo(name = "roles") var roles: String = "",
                      @ColumnInfo(name = "img") var image: String = "",
                      @ColumnInfo(name = "health") var health: String = "",
                      @ColumnInfo(name = "mana") var mana: String = "",
                      @ColumnInfo(name = "base_armor") var baseArmor: String = "",
                      @ColumnInfo(name = "attack") var attack: String = "",
                      @ColumnInfo(name = "str") var str: String = "",
                      @ColumnInfo(name = "agi") var agi: String = "",
                      @ColumnInfo(name = "int") var int: String = "",
                      @ColumnInfo(name = "attack_range") var attackRange: String = "",
                      @ColumnInfo(name = "projectile_speed") var projectileSpeed: String = "",
                      @ColumnInfo(name = "attack_rate") var attackRate: String = "",
                      @ColumnInfo(name = "move_speed") var moveSpeed: String = "",
                      @ColumnInfo(name = "turn_rate") var turnRate: String = "",
                      @ColumnInfo(name = "cm_enabled") var cmEnabled: Boolean = false)