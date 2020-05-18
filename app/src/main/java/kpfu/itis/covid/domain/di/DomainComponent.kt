package kpfu.itis.covid.domain.di

import dagger.Subcomponent
import kpfu.itis.covid.presentation.list.di.component.CountriesComponent
import kpfu.itis.covid.presentation.details.di.component.CountryDetailsComponent

@DomainScope
@Subcomponent(modules = [DomainModule::class])
interface DomainComponent {

    @Subcomponent.Builder
    interface Builder {
        fun domainModule(domainModule: DomainModule) : Builder
        fun build() : DomainComponent
    }

    fun plusCountriesComponent() : CountriesComponent.Builder
    fun plusCountryDetailsComponent() : CountryDetailsComponent.Builder

}
