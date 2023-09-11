package com.mtoz147.ja1_kotlincountries.service

import com.mtoz147.ja1_kotlincountries.model.Country
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface CountryAPI {

    //GET, POST, DELETE

    //https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json
    //BASE_URL ->https://raw.githubusercontent.com/
    //extention -> atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json

    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getCountries(): Single<List<Country>>

    //if we need to perform multiple 'get' and 'post' operations, we can continue here.

    //The 'single' operation performs once and stops.
    //The 'observable' operation performs continuously.
    //https://bugfender.com/blog/data-flows-in-rxjava2-observable-flowable-single-maybe-completable/

    //https://github.com/ReactiveX/RxJava
    //In RxJava, the dedicated Flowable class is designated to support backpressure and
    // Observable is dedicated to the non-backpressured operations (short sequences, GUI interactions, etc.).
    // The other types, Single, Maybe and Completable don't support backpressure nor should they;
    // there is always room to store one item temporarily.
}