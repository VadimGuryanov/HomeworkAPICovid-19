package kpfu.itis.covid.presentation.list.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kpfu.itis.covid.di.module.ViewModelModule
import kpfu.itis.covid.di.key.ViewModelKey
import kpfu.itis.covid.presentation.list.CountriesViewModel

@Module(
    includes = [
        ViewModelModule::class
    ]
)
abstract class CountriesViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(CountriesViewModel::class)
    abstract fun bindCountriesViewModel(
        countriesViewModel: CountriesViewModel
    ): ViewModel

}
