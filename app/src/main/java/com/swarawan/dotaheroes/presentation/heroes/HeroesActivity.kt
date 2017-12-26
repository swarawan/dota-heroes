package com.swarawan.dotaheroes.presentation.heroes

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
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

        presenter.attachView(heroView)

        recycler_hero.adapter = adapter
        recycler_hero.layoutManager = LinearLayoutManager(this)
        recycler_hero.setHasFixedSize(true)

        swipe.setOnRefreshListener { onRefreshListener }
        swipe.post { onRefreshListener.onRefresh() }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.option_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.menu_search)?.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))

        return true
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    private val onRefreshListener = SwipeRefreshLayout.OnRefreshListener { presenter.getHeroes() }

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
