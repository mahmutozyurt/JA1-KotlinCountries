package com.mtoz147.ja1_kotlincountries.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mtoz147.ja1_kotlincountries.model.Country

@Dao  //We have written the necessary methods to access the database.
interface CountryDAO {
    //Data Access Object

    @Insert
    suspend fun insertAll(vararg countries:Country):List<Long>

    //Insert-> INSERT INTO

    // suspend -> coroutine, pause&resume
    //vararg->multiple country objects
    //List<Long>->primary keys
    // We are creating a list that will return a primary ID
    @Query("SELECT * FROM country") //Since we haven't changed the table name on the model , it is saved as the class name.

    suspend fun getAllCouuntries():List<Country>

    @Query("SELECT*FROM country WHERE uuid=:countryId")
    suspend fun getCountry(countryId:Int):Country //It will be needed for use in the CountryFragment.


    @Query("DELETE FROM country")
    suspend fun deleteAllCountries()
}