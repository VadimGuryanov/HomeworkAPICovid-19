package kpfu.itis.covid.data.repository.di

import dagger.Subcomponent
import kpfu.itis.covid.domain.di.DomainComponent

@RepositoryScope
@Subcomponent(modules = [RepositoryModule::class])
interface RepositoryComponent {

    fun plusDomainComponent() : DomainComponent.Builder

    @Subcomponent.Builder
    interface Builder {
        fun repositoryModule(repositoryModule: RepositoryModule)
        fun build() : RepositoryComponent
    }

}
