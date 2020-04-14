package kpfu.itis.covid.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun profideContext(app : Application) : Context = app.applicationContext

}
