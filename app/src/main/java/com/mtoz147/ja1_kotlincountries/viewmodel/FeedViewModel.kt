package com.mtoz147.ja1_kotlincountries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mtoz147.ja1_kotlincountries.model.Country
import com.mtoz147.ja1_kotlincountries.service.CountryAPIService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class FeedViewModel : ViewModel() {

    private val countryApiService=CountryAPIService()

    //It is used to free up memory held by calls As you download data from the internet.
    private val disposable=CompositeDisposable()

    //ViewModel is not affected by configuration changes; it has its own lifecycle.
    //https://developer.android.com/topic/libraries/architecture/livedata?hl=en
    val countries=MutableLiveData<List<Country>>()
    val countryError=MutableLiveData<Boolean>()
    val countryLoading=MutableLiveData<Boolean>()


    fun refreshData(){
        getDataFromAPI()



        /*//It has been used for testing.
        val country=Country("TURKEY","ASIA","ANKARA","TRY","TURKISH","www.ss.com")
        val country2=Country("GERMANY","EUROPE","BERLIN","EUR","GERMAN","www.ss.com")
        val country3=Country("NETHERLAND","EUROPE","AMSTERDAM","EUR","ENGLISH","www.ss.com")

        val countryList= arrayListOf<Country>(country,country2,country3)
        countries.value=countryList
        countryError.value=false // It has been tested with "true" and is functioning properly.
        countryLoading.value=false //It has been tested with "true" and is functioning properly.*/




    }
private fun getDataFromAPI(){
countryLoading.value=true
    disposable.add(
        countryApiService.getData()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object :DisposableSingleObserver<List<Country>>(){
                override fun onSuccess(t: List<Country>) {
                    countries.value=t
                    countryError.value=false
                    countryLoading.value=false
                }

                override fun onError(e: Throwable) {
                    countryError.value=true
                    countryLoading.value=false
                    e.printStackTrace()
                }

            })
    )
}
}