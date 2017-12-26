package com.swarawan.dotaheroes.presentation.heroes

/**
 * Created by rioswarawan on 12/22/17.
 */
data class Hero(val id: Long,
                val name: String,
                val primaryAttribute: String,
                val attackType: String,
                val roles: List<String>,
                val image: String,
                val health: String,
                val mana: String,
                val armor: String,
                val attack: String,
                val baseStr: String,
                val baseAgi: String,
                val baseInt: String,
                val attackRange: String,
                val moveSpeed: String,
                val turnRate: String,
                val cmEnable: Boolean)