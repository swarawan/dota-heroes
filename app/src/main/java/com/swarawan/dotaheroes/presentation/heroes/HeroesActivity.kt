package com.swarawan.dotaheroes.presentation.heroes

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.widget.SearchView
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

        swipe.isEnabled = false
        recycler_hero.adapter = adapter
        recycler_hero.layoutManager = LinearLayoutManager(this)
        recycler_hero.setHasFixedSize(true)

        presenter.attachView(heroView)
        presenter.getHeroes()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.option_menu, menu)

        val searchView = menu?.findItem(R.id.menu_search)?.actionView as SearchView
        searchView.setOnQueryTextListener(onQueryTextListener)

        return true
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    private val onQueryTextListener = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            return false
        }
    }

    private val heroView = object : HeroView {

        override fun showLoading() {
            if (!swipe.isRefreshing) {
                swipe.isRefreshing = true
            }
        }

        override fun hideLoading() {
            if (swipe.isRefreshing) {
                swipe.isRefreshing = false
            }
        }

        override fun displayHero(fetchedHeroes: List<Hero>) {
            heroes.clear()
            heroes.addAll(fetchedHeroes)
            adapter.notifyDataSetChanged()
        }
    }
}
