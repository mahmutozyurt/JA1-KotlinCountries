package com.mtoz147.ja1_kotlincountries.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mtoz147.ja1_kotlincountries.model.Country
import com.mtoz147.ja1_kotlincountries.service.CountryAPIService
import com.mtoz147.ja1_kotlincountries.service.CountryDatabase
import com.mtoz147.ja1_kotlincountries.util.CustomSharedPreferences
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch


class FeedViewModel(application: Application) : BaseViewModel(application) {//coroutine scopes has been added.

    private val countryApiService=CountryAPIService()

    //It is used to free up memory held by calls As you download data from the internet.
    private val disposable=CompositeDisposable()

    private var customPreferences=CustomSharedPreferences(getApplication())
    private var refreshTime=1*60*1000*1000*1000L //is used to convert from nanosecond to 1 minute
    //ViewModel is not affected by configuration changes; it has its own lifecycle.
    //https://developer.android.com/topic/libraries/architecture/livedata?hl=en
    val countries=MutableLiveData<List<Country>>()
    val countryError=MutableLiveData<Boolean>()
    val countryLoading=MutableLiveData<Boolean>()


    fun refreshData(){
        val updateTime=customPreferences.getTime()
        if(updateTime!=null&&updateTime!=0L&&System.nanoTime()-updateTime<refreshTime){
            getDataFromSQLite()
        }else{
            getDataFromAPI()
        }
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
    fun refreshFromAPI(){
        getDataFromAPI()
    }


    private fun getDataFromSQLite(){
        countryLoading.value=true
        launch {
            val countries=CountryDatabase(getApplication()).countryDao().getAllCouuntries()
            showCountries(countries)
            Toast.makeText(getApplication(),"Countries From SQLite",Toast.LENGTH_LONG).show()
        }
    }
private fun getDataFromAPI(){
countryLoading.value=true
    disposable.add(
        countryApiService.getData()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object :DisposableSingleObserver<List<Country>>(){
                override fun onSuccess(t: List<Country>) {
                        storeInSQLite(t)
                    Toast.makeText(getApplication(),"Countries From API",Toast.LENGTH_LONG).show()
                }

                override fun onError(e: Throwable) {
                    countryError.value=true
                    countryLoading.value=false
                    e.printStackTrace()
                }

            })
    )
}
    private fun showCountries(countryList:List<Country>){
        countries.value=countryList
        countryError.value=false
        countryLoading.value=false
    }
    private fun storeInSQLite(list: List<Country>){
    launch {
        val dao=CountryDatabase(getApplication()).countryDao()
        dao.deleteAllCountries()
        val listLong = dao.insertAll(*list.toTypedArray())//The 'toTypeArray' will make the data in the list individual.
        var i=0
        while (i<list.size){
            list[i].uuid=listLong[i].toInt() //Country list assignments are made through UUID.
            i=i+1
        }
        showCountries(list)

    }
        customPreferences.saveTime(System.nanoTime())
    }


}