package com.mtoz147.ja1_kotlincountries.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mtoz147.ja1_kotlincountries.model.Country


@Database(entities = arrayOf(Country::class),version=1)
abstract class CountryDatabase:RoomDatabase() {
    abstract fun countryDao():CountryDAO
    //Our goal is to create a single object from the database,
    // and when we try to access it from different threads,
    // this can lead to conflicts.
    // To prevent this, we will create the country database using the singleton pattern.
    //Singleton -> It is a class from which only a single object can be created.
    //We use "companion object"" to make it accessible from anywhere

    companion object{
       @Volatile private var instance:CountryDatabase?= null
        private val lock=Any()
        operator fun invoke(context: Context)= instance?: synchronized(lock){
        instance?: makeDatabase(context).also {
            instance=it
        }
        }

        private fun makeDatabase(context: Context)= Room.databaseBuilder(
            context.applicationContext,CountryDatabase::class.java,"countrydatabase").build()
    }
}