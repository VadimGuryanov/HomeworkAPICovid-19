package kpfu.itis.covid.presentation.details

import android.widget.ImageView
import androidx.annotation.MainThread
import androidx.databinding.BindingAdapter
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

class CountryViewModel(
    private val interactor: CovidInteractor
) : ViewModel() {

    private var disposable: Disposable? = null
    private lateinit var countryLiveData: MutableLiveData<Response<CountryCovidInfo>>

    @MainThread
    fun getCountryInfo(id: Long): LiveData<Response<CountryCovidInfo>> {
        countryLiveData = MutableLiveData()
        disposable = interactor
            .getCountryInfoByName(id.toString())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    val countriesLiveDataImm = countryLiveData
                    countriesLiveDataImm.value = Response.success(it)
                    countryLiveData = countriesLiveDataImm
                },
                onError = {
                    val countriesLiveDataImm = countryLiveData
                    countriesLiveDataImm.value = Response.error(it)
                    countryLiveData = countriesLiveDataImm
                }
            )
        return countryLiveData
    }

    override fun onCleared() {
        disposable?.dispose()
    }

}

@BindingAdapter("android:src")
fun download(view: ImageView, url: String?) {
    Glide
        .with(view.context)
        .load(url)
        .centerCrop()
        .into(view)
}
