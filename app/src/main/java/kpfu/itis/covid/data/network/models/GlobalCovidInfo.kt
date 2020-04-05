package kpfu.itis.covid.data.network.models

data class GlobalCovidInfo(
    val active: Int,
    val affectedCountries: Int,
    val cases: Int,
    val deaths: Int,
    val recovered: Int,
    val updated: Long
)
