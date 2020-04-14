package kpfu.itis.covid.data.repository

import io.reactivex.Single
import kpfu.itis.covid.data.network.CovidService
import kpfu.itis.covid.data.network.models.CountryCovidInfo
import kpfu.itis.covid.data.network.models.GlobalCovidInfo

class CovidRepositoryImpl constructor(
    private val api: CovidService
) : CovidRepository{

    override fun getGlobalInfo(): Single<GlobalCovidInfo> =
        api.getGlobalInfo()

    override fun getCountriesInfo(): Single<List<CountryCovidInfo>> =
        api.getCountriesInfo()

    override fun getCountriesInfoSortBy(sort: String): Single<List<CountryCovidInfo>> =
        api.getCountriesInfoSortBy(sort)

    override fun getCountryInfoByName(name: String): Single<CountryCovidInfo> =
        api.getCountriesInfoByName(name)
}
