package kpfu.itis.covid.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import kpfu.itis.covid.R
import kpfu.itis.covid.databinding.ActivityDetailsCountryBinding
import kpfu.itis.covid.presentation.ViewModelFactory

class CountryDetailsActivity : AppCompatActivity() {

    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var binding : ActivityDetailsCountryBinding

    companion object {

        private const val KEY_COUNTRY_ID = "country_id"

        fun start(context: Context, countryId: Long?) {
            val intent = Intent(context, CountryDetailsActivity::class.java).apply {
                putExtra(KEY_COUNTRY_ID, countryId)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_country)
        viewModelFactory = ViewModelFactory()
        initCountry(intent.getLongExtra(KEY_COUNTRY_ID, -1))
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_details_country)
    }

    private fun initCountry(id : Long) {
        getViewModel().apply {
            getCountryInfo(id).observe(this@CountryDetailsActivity, Observer {
                when  {
                    it.data != null -> {
                        binding.country = it.data
                    }
                    it.error != null -> {
                        Snackbar.make(
                            findViewById(android.R.id.content),
                            it.error.message ?: "No connection",
                            Snackbar.LENGTH_INDEFINITE)
                            .show()
                    }
                    else -> {
                        Snackbar.make(
                            findViewById(android.R.id.content),
                            "No connection",
                            Snackbar.LENGTH_INDEFINITE)
                            .show()
                    }
                }
            })
        }
    }


    private fun getViewModel() = ViewModelProvider(this, viewModelFactory).get(CountryViewModel::class.java)
}