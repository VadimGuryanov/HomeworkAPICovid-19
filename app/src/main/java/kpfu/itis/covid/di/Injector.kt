package kpfu.itis.covid.di

import kpfu.itis.covid.App
import kpfu.itis.covid.data.repository.di.RepositoryComponent
import kpfu.itis.covid.di.component.AppComponent
import kpfu.itis.covid.di.component.DaggerAppComponent
import kpfu.itis.covid.domain.di.DomainComponent
import kpfu.itis.covid.presentation.list.di.component.CountriesComponent
import kpfu.itis.covid.presentation.details.di.component.CountryDetailsComponent

object Injector {

    lateinit var appComponent: AppComponent
    private var repositoryComponent: RepositoryComponent? = null
    private var domainComponent: DomainComponent? = null
    private var countryDetailsComponent: CountryDetailsComponent? = null
    private var countriesComponent: CountriesComponent? = null

    fun init(app: App) {
        appComponent = DaggerAppComponent.builder()
            .application(app)
            .build()
    }

    fun plusRepositoryComponent(): RepositoryComponent = repositoryComponent
        ?: appComponent
        .plusRepositoryComponent()
        .build().also {
            repositoryComponent = it
        }

    fun clearReposioryComponent() {
        repositoryComponent = null
    }

    fun plusDomainComponent(): DomainComponent = domainComponent
        ?: plusRepositoryComponent()
        .plusDomainComponent()
        .build().also {
            domainComponent = it
        }

    fun clearDomainComponent() {
        domainComponent = null
    }

    fun plusCountryDetailsComponent(): CountryDetailsComponent = countryDetailsComponent
        ?: plusDomainComponent()
        .plusCountryDetailsComponent()
        .build().also {
            countryDetailsComponent = it
        }

    fun clearCountryDetailsComponent() {
        countryDetailsComponent = null
    }

    fun plusCountriesListComponent(): CountriesComponent = countriesComponent
        ?: plusDomainComponent()
        .plusCountriesComponent()
        .build().also {
            countriesComponent = it
        }

    fun clearCountriesListComponent() {
        countriesComponent = null
    }
}