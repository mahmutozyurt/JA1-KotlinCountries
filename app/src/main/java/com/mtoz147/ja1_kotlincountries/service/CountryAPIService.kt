package com.mtoz147.ja1_kotlincountries.service

import com.mtoz147.ja1_kotlincountries.model.Country
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CountryAPIService {
    //A service has been written to fetch data
    //https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json
    //BASE_URL ->https://raw.githubusercontent.com/

    private val BASE_URL ="https://raw.githubusercontent.com/"
    private val api=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(CountryAPI::class.java)

fun getData():Single<List<Country>>{
    return api.getCountries()
}


    //What needs to be done is to create an object from this class and fetch the data.
}