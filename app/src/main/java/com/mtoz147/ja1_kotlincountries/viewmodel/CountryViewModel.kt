package com.mtoz147.ja1_kotlincountries.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mtoz147.ja1_kotlincountries.model.Country
import com.mtoz147.ja1_kotlincountries.service.CountryDatabase
import kotlinx.coroutines.launch

class CountryViewModel(application: Application): BaseViewModel(application) {
    val countryLiveData=MutableLiveData<Country>()


    fun getDataFromRoom(uuid:Int){
        launch {
            val dao=CountryDatabase(getApplication()).countryDao()
            val country=dao.getCountry(uuid)
            countryLiveData.value=country
        }

        /*//It has been used for testing.
        val country=Country("TURKEY","ASİA","ANKARA","TRY","TURKISH","www.ss.com")
        countryLiveData.value=country*/

    }
}