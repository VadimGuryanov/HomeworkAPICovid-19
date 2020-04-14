package kpfu.itis.covid.di.module

import dagger.Module
import dagger.Provides
import kpfu.itis.covid.data.network.CovidService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideCovidService(retrofit: Retrofit) : CovidService =
        retrofit.create(CovidService::class.java)

}
