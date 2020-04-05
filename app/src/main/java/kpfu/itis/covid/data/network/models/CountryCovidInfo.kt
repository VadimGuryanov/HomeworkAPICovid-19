package kpfu.itis.covid.data.network.models

data class CountryCovidInfo(
    val active: Int,
    val cases: Int,
    val casesPerOneMillion: Double,
    val country: String,
    val countryInfo: CountryInfo,
    val critical: Int,
    val deaths: Int,
    val deathsPerOneMillion: Double,
    val recovered: Int,
    val todayCases: Int,
    val todayDeaths: Int,
    val updated: Long
)

data class CountryInfo(
    val _id: Long,
    val flag: String,
    val iso2: String,
    val iso3: String,
    val lat: Double,
    val long: Double
)
