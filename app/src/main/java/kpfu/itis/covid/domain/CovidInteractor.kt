package kpfu.itis.covid.domain

import io.reactivex.Single
import kpfu.itis.covid.data.network.models.CountryCovidInfo
import kpfu.itis.covid.data.network.models.GlobalCovidInfo

interface CovidInteractor {

    fun getGlobalInfo() : Single<GlobalCovidInfo>

    fun getCountriesInfo() : Single<List<CountryCovidInfo>>

    fun getCountriesInfoSortBy(sort: String) : Single<List<CountryCovidInfo>>

    fun getCountryInfoByName(name: String) : Single<CountryCovidInfo>

}
