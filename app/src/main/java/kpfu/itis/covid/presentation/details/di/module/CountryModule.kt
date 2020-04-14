package kpfu.itis.covid.presentation.details.di.module

import dagger.Module
import dagger.Provides
import kpfu.itis.covid.domain.CovidInteractor
import kpfu.itis.covid.presentation.details.CountryViewModel
import kpfu.itis.covid.presentation.details.di.scope.CountyDetailsScope

@Module
class CountryModule {

    @Provides
    @CountyDetailsScope
    fun provideCountryViewModel(interactor: CovidInteractor) : CountryViewModel =
        CountryViewModel(interactor)

}
