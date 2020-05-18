package kpfu.itis.covid.presentation.list

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_countries.*
import kpfu.itis.covid.di.Injector
import kpfu.itis.covid.R
import kpfu.itis.covid.presentation.ViewModelFactory
import kpfu.itis.covid.presentation.details.CountryDetailsActivity
import kpfu.itis.covid.presentation.list.recycleview.CountriesAdapter
import javax.inject.Inject

class CountriesActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        Injector.plusCountriesListComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)
        observeViewModel()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_search_view, menu)
        val searchItem: MenuItem? = menu?.findItem(R.id.action_search)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView: SearchView? = searchItem?.actionView as SearchView
        searchView?.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                getViewModel().apply {
                    getIdCountry(query ?: "").observe(this@CountriesActivity, Observer {
                        when {
                            it.data != null -> navigateTo(it.data)
                            it.error != null ->
                                Snackbar.make(
                                    findViewById(android.R.id.content),
                                    it.error.message ?: "No connection",
                                    Snackbar.LENGTH_INDEFINITE)
                                    .show()
                            else ->
                                Snackbar.make(
                                    findViewById(android.R.id.content),
                                    "we have problem",
                                    Snackbar.LENGTH_INDEFINITE)
                                    .show()
                        }
                    })
                }
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean = false
        })
        return super.onCreateOptionsMenu(menu)
    }

    private fun observeViewModel() {
        getViewModel().apply {
            getCountries().observe(this@CountriesActivity, Observer {
                when {
                    it.data != null ->
                        rv_countries.apply {
                            layoutManager = LinearLayoutManager(this@CountriesActivity)
                            adapter = CountriesAdapter(
                                it.data,
                                {navigateTo(it)},
                                {iv, url -> download(iv, url)}
                            )
                        }
                    it.error != null ->
                        Snackbar.make(
                            findViewById(android.R.id.content),
                            it.error.message ?: "No connection",
                            Snackbar.LENGTH_INDEFINITE)
                            .show()
                    else ->
                        Snackbar.make(
                            findViewById(android.R.id.content),
                            "we have problem",
                            Snackbar.LENGTH_INDEFINITE)
                            .show()
                }
            })
        }
    }

    private fun navigateTo(id : Long) {
        CountryDetailsActivity.start(this@CountriesActivity, id)
    }

    private fun getViewModel() = ViewModelProvider(this, viewModelFactory).get(CountriesViewModel::class.java)


    override fun onDestroy() {
        Injector.clearCountriesListComponent()
        super.onDestroy()
    }

}
