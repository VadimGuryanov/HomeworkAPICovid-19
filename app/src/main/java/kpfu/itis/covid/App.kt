package kpfu.itis.covid

import android.app.Application
import kpfu.itis.covid.di.Injector

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.init(this)
    }

}
