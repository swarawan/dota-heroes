package com.swarawan.dotaheroes.presentation.heroes

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.swarawan.dotaheroes.R
import com.swarawan.dotaheroes.base.InjectedActivity
import com.swarawan.dotaheroes.di.component.ActivityComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class HeroesActivity : InjectedActivity() {

    @Inject
    lateinit var heroes: MutableList<Hero>

    @Inject
    lateinit var adapter: HeroAdapter

    @Inject
    lateinit var presenter: HeroPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_hero.adapter = adapter
        recycler_hero.layoutManager = LinearLayoutManager(this)
        recycler_hero.setHasFixedSize(true)

        presenter.attachView(heroView)
        presenter.getHeroes()
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    private val heroView = object : HeroView {
        override fun showLoading() {

        }

        override fun hideLoading() {
        }

        override fun displayHero(fetchedHeroes: List<Hero>) {
            heroes.clear()
            heroes.addAll(fetchedHeroes)
            adapter.notifyDataSetChanged()
        }
    }
}
