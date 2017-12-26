package com.swarawan.dotaheroes.presentation.search

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.ajalt.timberkt.d
import com.swarawan.dotaheroes.R

/**
 * Created by rioswarawan on 12/26/17.
 */
class SearchResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        handleSearchResult(intent)
    }

    private fun handleSearchResult(intent: Intent) {
        if(Intent.ACTION_SEARCH == intent.action) {
            val query: String = intent.getStringExtra(SearchManager.QUERY)
            d { "Search Query : $query" }
        }
    }
}