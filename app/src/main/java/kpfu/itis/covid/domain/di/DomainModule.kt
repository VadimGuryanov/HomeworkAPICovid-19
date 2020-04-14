package kpfu.itis.covid.domain.di

import dagger.Module
import dagger.Provides
import kpfu.itis.covid.data.repository.CovidRepository
import kpfu.itis.covid.domain.CovidInteractor
import kpfu.itis.covid.domain.CovidInteractorImpl

@Module
class DomainModule {

    @Provides
    @DomainScope
    fun provideInteractor(repository: CovidRepository) : CovidInteractor =
        CovidInteractorImpl(repository)

}
