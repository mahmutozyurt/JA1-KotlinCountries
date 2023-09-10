package com.mtoz147.ja1_kotlincountries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mtoz147.ja1_kotlincountries.model.Country

class FeedViewModel : ViewModel() {
    //ViewModel is not affected by configuration changes; it has its own lifecycle.
    //https://developer.android.com/topic/libraries/architecture/livedata?hl=en
    val countries=MutableLiveData<List<Country>>()
    val countryError=MutableLiveData<Boolean>()
    val countryLoading=MutableLiveData<Boolean>()

    //It has been used for testing.
    fun refreshData(){
        val country=Country("TURKEY","ASIA","ANKARA","TRY","TURKISH","www.ss.com")
        val country2=Country("GERMANY","EUROPE","BERLIN","EUR","GERMAN","www.ss.com")
        val country3=Country("NETHERLAND","EUROPE","AMSTERDAM","EUR","ENGLISH","www.ss.com")

        val countryList= arrayListOf<Country>(country,country2,country3)
        countries.value=countryList
        countryError.value=false
        countryLoading.value=false
    }

}