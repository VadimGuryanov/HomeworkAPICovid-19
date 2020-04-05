package kpfu.itis.covid.presentation.list

import android.content.Context
import android.widget.ImageView
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kpfu.itis.covid.data.network.models.CountryCovidInfo
import kpfu.itis.covid.data.network.models.Response
import kpfu.itis.covid.domain.CovidInteractor
import kpfu.itis.covid.domain.CovidInteractorImpl

class CountriesViewModel constructor(
    private val interactor: CovidInteractor = CovidInteractorImpl()
) : ViewModel() {

    private var disposable: Disposable? = null
    private lateinit var countriesLiveData: MutableLiveData<Response<List<CountryCovidInfo>>>
    private lateinit var idLiveData: MutableLiveData<Response<Long>>

    @MainThread
    fun getCountries() : LiveData<Response<List<CountryCovidInfo>>> {
        countriesLiveData = MutableLiveData()
        disposable = interactor
            .getCountriesInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    val countriesLiveDataImm = countriesLiveData
                    countriesLiveDataImm.value = Response.success(it)
                    countriesLiveData = countriesLiveDataImm
                },
                onError = {
                    val countriesLiveDataImm = countriesLiveData
                    countriesLiveDataImm.value = Response.error(it)
                    countriesLiveData = countriesLiveDataImm
                }
            )
        return countriesLiveData
    }

    fun getIdCountry(name : String) : LiveData<Response<Long>> {
        idLiveData = MutableLiveData()
        disposable = interactor
            .getCountryInfoByName(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map{it.countryInfo._id}
            .subscribeBy(
                onSuccess = {
                    val idLiveDataImm = idLiveData
                    idLiveDataImm.value = Response.success(it)
                    idLiveData = idLiveDataImm
                },
                onError = {
                    val countriesLiveDataImm = idLiveData
                    countriesLiveDataImm.value = Response.error(it)
                    idLiveData = countriesLiveDataImm
                }
            )
        return idLiveData
    }

    fun download(view: ImageView, url: String) {
        Glide
            .with(view.context)
            .load(url)
            .centerCrop()
            .into(view)
    }


    override fun onCleared() {
        disposable?.dispose()
    }

}
