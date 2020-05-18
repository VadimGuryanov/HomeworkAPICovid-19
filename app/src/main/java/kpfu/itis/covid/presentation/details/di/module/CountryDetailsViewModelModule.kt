package kpfu.itis.covid.presentation.details.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kpfu.itis.covid.di.module.ViewModelModule
import kpfu.itis.covid.presentation.details.CountryViewModel
import kpfu.itis.covid.di.key.ViewModelKey

@Module(
    includes = [
        ViewModelModule::class
    ]
)
abstract class CountryDetailsViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(CountryViewModel::class)
    abstract fun bindCountryViewModel(
        countryViewModel: CountryViewModel
    ): ViewModel

}
