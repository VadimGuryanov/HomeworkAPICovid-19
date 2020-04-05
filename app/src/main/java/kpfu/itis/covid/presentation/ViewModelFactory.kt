package kpfu.itis.covid.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kpfu.itis.covid.presentation.details.CountryViewModel
import kpfu.itis.covid.presentation.list.CountriesViewModel

class ViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(CountriesViewModel::class.java) -> {
                CountriesViewModel() as? T
                    ?: throw IllegalArgumentException("Unknown ViewModel class")
            }
            modelClass.isAssignableFrom(CountryViewModel::class.java) -> {
                CountryViewModel() as? T
                    ?: throw IllegalArgumentException("Unknown ViewModel class")
            }
            else -> {
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
}
