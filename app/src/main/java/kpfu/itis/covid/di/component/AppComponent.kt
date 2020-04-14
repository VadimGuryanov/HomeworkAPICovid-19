package kpfu.itis.covid.di.component

import dagger.BindsInstance
import dagger.Component
import kpfu.itis.covid.App
import kpfu.itis.covid.data.repository.di.RepositoryComponent
import kpfu.itis.covid.di.module.AppModule
import kpfu.itis.covid.di.module.NetModule
import kpfu.itis.covid.di.module.ServiceModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        ServiceModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder
        fun build(): AppComponent
    }

    fun plusRepositoryComponent() : RepositoryComponent.Builder

}
