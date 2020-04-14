package kpfu.itis.covid.presentation.list.di.component

import dagger.Subcomponent
import kpfu.itis.covid.presentation.list.di.module.CountriesModule
import kpfu.itis.covid.presentation.list.di.module.CountriesViewModelModule
import kpfu.itis.covid.presentation.list.di.scope.CountriesScope
import kpfu.itis.covid.presentation.list.CountriesActivity

@CountriesScope
@Subcomponent(modules = [CountriesModule::class, CountriesViewModelModule::class])
interface CountriesComponent {

    @Subcomponent.Builder
    interface Builder {
        fun provideCountriesModule(countriesModule: CountriesModule) : Builder
        fun build() : CountriesComponent
    }

    fun inject(countriesActivity: CountriesActivity)

}
