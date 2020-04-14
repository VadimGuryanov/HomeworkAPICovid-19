package kpfu.itis.covid.domain

import io.reactivex.Single
import kpfu.itis.covid.data.network.models.CountryCovidInfo
import kpfu.itis.covid.data.network.models.GlobalCovidInfo
import kpfu.itis.covid.data.repository.CovidRepository

class CovidInteractorImpl (
    private val repository: CovidRepository
) : CovidInteractor{

    override fun getGlobalInfo(): Single<GlobalCovidInfo> =
        repository.getGlobalInfo()

    override fun getCountriesInfo(): Single<List<CountryCovidInfo>> =
        repository.getCountriesInfo()

    override fun getCountriesInfoSortBy(sort: String): Single<List<CountryCovidInfo>> =
        repository.getCountriesInfoSortBy(sort)

    override fun getCountryInfoByName(name: String): Single<CountryCovidInfo> =
        repository.getCountryInfoByName(name)
}
