package com.swarawan.dotaheroes.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by rioswarawan on 12/26/17.
 */

@Entity(tableName = "Hero")
data class HeroEntity(@PrimaryKey val id: Number,
                      @ColumnInfo(name = "name") val name: String = "",
                      @ColumnInfo(name = "primary_attr") val primaryAttr: String = "",
                      @ColumnInfo(name = "attack_type") val attackType: String = "",
                      @ColumnInfo(name = "roles") val roles: List<String> = ArrayList<String>(),
                      @ColumnInfo(name = "img") val image: String = "",
                      @ColumnInfo(name = "base_health") val baseHealth: Number = 0,
                      @ColumnInfo(name = "base_health_regen") val baseHealthRegen: Double = 0.0,
                      @ColumnInfo(name = "base_mana") val baseMana: Number = 0,
                      @ColumnInfo(name = "base_mana_regen") val baseManaRegen: Double = 0.0,
                      @ColumnInfo(name = "base_armor") val baseArmor: Number = 0,
                      @ColumnInfo(name = "base_attack_min") val baseAttackMin: Number = 0,
                      @ColumnInfo(name = "base_attack_max") val baseAttackMax: Number = 0,
                      @ColumnInfo(name = "base_str") val baseStr: Number = 0,
                      @ColumnInfo(name = "base_agi") val baseAgi: Number = 0,
                      @ColumnInfo(name = "base_int") val baseInt: Number = 0,
                      @ColumnInfo(name = "str_gain") val strGain: Double = 0.0,
                      @ColumnInfo(name = "agi_gain") val agiGain: Double = 0.0,
                      @ColumnInfo(name = "int_gain") val intGain: Double = 0.0,
                      @ColumnInfo(name = "attack_range") val attackRange: Number = 0,
                      @ColumnInfo(name = "projectile_speed") val projectileSpeed: Number = 0,
                      @ColumnInfo(name = "attack_rate") val attackRate: Double = 0.0,
                      @ColumnInfo(name = "move_speed") val moveSpeed: Number = 0,
                      @ColumnInfo(name = "turn_rate") val turnRate: Double = 0.0,
                      @ColumnInfo(name = "cm_enabled") val cmEnabled: Boolean = false)