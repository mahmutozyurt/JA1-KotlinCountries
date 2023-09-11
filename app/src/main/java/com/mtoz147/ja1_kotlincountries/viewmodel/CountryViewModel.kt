package com.mtoz147.ja1_kotlincountries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mtoz147.ja1_kotlincountries.model.Country

class CountryViewModel: ViewModel() {
    val countryLiveData=MutableLiveData<Country>()

    ////It has been used for testing.
    fun getDataFromRoom(){
        val country=Country("TURKEY","ASİA","ANKARA","TRY","TURKISH","www.ss.com")
        countryLiveData.value=country

    }
}