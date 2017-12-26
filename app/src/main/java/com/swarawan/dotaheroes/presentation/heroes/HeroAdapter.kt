package com.swarawan.dotaheroes.presentation.heroes

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.swarawan.dotaheroes.R
import com.swarawan.dotaheroes.utils.layoutInflater
import kotlinx.android.synthetic.main.item_heroes.view.*

/**
 * Created by rioswarawan on 12/22/17.
 */
class HeroAdapter(private val context: Context, private val heroes: List<Hero>) : RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = heroes[position]

        holder.name.text = hero.name
        holder.health.text = "Health: ${hero.health}"
        holder.mana.text = "Mana: ${hero.mana}"
        holder.str.text = "STR: ${hero.str}"
        holder.agi.text = "AGI: ${hero.agi}"
        holder.int.text = "INT: ${hero.int}"
        holder.attributeStr.visibility = if (hero.primaryAttribute == "str") View.VISIBLE else View.GONE
        holder.attributeAgi.visibility = if (hero.primaryAttribute == "agi") View.VISIBLE else View.GONE
        holder.attributeInt.visibility = if (hero.primaryAttribute == "int") View.VISIBLE else View.GONE

        Glide.with(context).load(hero.image).into(holder.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = context.layoutInflater.inflate(R.layout.item_heroes, parent, false)
        return HeroViewHolder(view)
    }

    override fun getItemCount(): Int {
        return heroes.size
    }

    override fun getItemId(position: Int): Long {
        return heroes[position].id
    }

    class HeroViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.image_hero
        val name = itemView.text_hero_name
        val attributeStr = itemView.text_hero_attribute_str
        val attributeAgi = itemView.text_hero_attribute_agi
        val attributeInt = itemView.text_hero_attribute_int
        val health = itemView.text_health
        val mana = itemView.text_mana
        val str = itemView.text_str
        val agi = itemView.text_agi
        val int = itemView.text_int
    }
}