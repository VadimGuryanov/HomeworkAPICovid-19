package kpfu.itis.covid.presentation.details.di.component

import dagger.Subcomponent
import kpfu.itis.covid.presentation.details.CountryDetailsActivity
import kpfu.itis.covid.presentation.details.di.module.CountryDetailsViewModelModule
import kpfu.itis.covid.presentation.details.di.module.CountryModule
import kpfu.itis.covid.presentation.details.di.scope.CountyDetailsScope

@CountyDetailsScope
@Subcomponent(modules = [CountryModule::class, CountryDetailsViewModelModule::class])
interface CountryDetailsComponent {

    @Subcomponent.Builder
    interface Builder {
        fun provideCountryModule(countryModule: CountryModule) : Builder
        fun build() : CountryDetailsComponent
    }

    fun inject(countryDetailsActivity: CountryDetailsActivity)

}
