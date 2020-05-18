package kpfu.itis.covid.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import kpfu.itis.covid.presentation.ViewModelFactory

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory

}
