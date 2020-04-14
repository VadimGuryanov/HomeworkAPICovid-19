package kpfu.itis.covid.data.repository.di

import dagger.Module
import dagger.Provides
import kpfu.itis.covid.data.network.CovidService
import kpfu.itis.covid.data.repository.CovidRepository
import kpfu.itis.covid.data.repository.CovidRepositoryImpl
import kpfu.itis.covid.data.repository.di.RepositoryScope

@Module
class RepositoryModule {

    @Provides
    @RepositoryScope
    fun provideRepository(covidService: CovidService) : CovidRepository =
        CovidRepositoryImpl(covidService)

}
