package kpfu.itis.covid.data.repository

import io.reactivex.Single
import kpfu.itis.covid.data.network.models.CountryCovidInfo
import kpfu.itis.covid.data.network.models.GlobalCovidInfo

interface CovidRepository {

    fun getGlobalInfo() : Single<GlobalCovidInfo>

    fun getCountriesInfo() : Single<List<CountryCovidInfo>>

    fun getCountriesInfoSortBy(sort: String) : Single<List<CountryCovidInfo>>

    fun getCountryInfoByName(name: String) : Single<CountryCovidInfo>

}
