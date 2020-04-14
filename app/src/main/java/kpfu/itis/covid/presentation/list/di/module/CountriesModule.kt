package kpfu.itis.covid.presentation.list.di.module

import dagger.Module
import dagger.Provides
import kpfu.itis.covid.domain.CovidInteractor
import kpfu.itis.covid.presentation.list.di.scope.CountriesScope
import kpfu.itis.covid.presentation.list.CountriesViewModel

@Module
class CountriesModule {

    @Provides
    @CountriesScope
    fun provideCountriesViewModel(interactor: CovidInteractor) : CountriesViewModel =
        CountriesViewModel(interactor)

}
