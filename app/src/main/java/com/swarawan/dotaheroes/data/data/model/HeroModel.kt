package com.swarawan.dotaheroes.data.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by rioswarawan on 12/23/17.
 */

data class HeroModel(@field:SerializedName("id") val id: Long = 0,
                     @field:SerializedName("localized_name") val localizedName: String = "",
                     @field:SerializedName("primary_attr") val primaryAttr: String = "",
                     @field:SerializedName("attack_type") val attackType: String = "",
                     @field:SerializedName("roles") val roles: List<String> = ArrayList<String>(),
                     @field:SerializedName("img") val image: String = "",
                     @field:SerializedName("base_health") val baseHealth: Int = 0,
                     @field:SerializedName("base_health_regen") val baseHealthRegen: Double = 0.0,
                     @field:SerializedName("base_mana") val baseMana: Int = 0,
                     @field:SerializedName("base_mana_regen") val baseManaRegen: Double = 0.0,
                     @field:SerializedName("base_armor") val baseArmor: Int = 0,
                     @field:SerializedName("base_attack_min") val baseAttackMin: Int = 0,
                     @field:SerializedName("base_attack_max") val baseAttackMax: Int = 0,
                     @field:SerializedName("base_str") val baseStr: Int = 0,
                     @field:SerializedName("base_agi") val baseAgi: Int = 0,
                     @field:SerializedName("base_int") val baseInt: Int = 0,
                     @field:SerializedName("str_gain") val strGain: Double = 0.0,
                     @field:SerializedName("agi_gain") val agiGain: Double = 0.0,
                     @field:SerializedName("int_gain") val intGain: Double = 0.0,
                     @field:SerializedName("attack_range") val attackRange: Int = 0,
                     @field:SerializedName("projectile_speed") val projectileSpeed: Int = 0,
                     @field:SerializedName("attack_rate") val attackRate: Double = 0.0,
                     @field:SerializedName("move_speed") val moveSpeed: Int = 0,
                     @field:SerializedName("turn_rate") val turnRate: Double = 0.0,
                     @field:SerializedName("cm_enabled") val cmEnabled: Boolean = false)