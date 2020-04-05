package kpfu.itis.covid.data.network

import io.reactivex.Single
import kpfu.itis.covid.data.network.models.CountryCovidInfo
import kpfu.itis.covid.data.network.models.GlobalCovidInfo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CovidService {

    @GET("all")
    fun getGlobalInfo() : Single<GlobalCovidInfo>

    @GET("countries")
    fun getCountriesInfo() : Single<List<CountryCovidInfo>>

    @GET("countries")
    fun getCountriesInfoSortBy(@Query("sort") sort: String) : Single<List<CountryCovidInfo>>

    @GET("countries/{country}")
    fun getCountriesInfoByName(@Path("country") name: String) : Single<CountryCovidInfo>

}
