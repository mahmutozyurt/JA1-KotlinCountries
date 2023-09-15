package com.mtoz147.ja1_kotlincountries.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity//Regarding the use of Room
data class Country(
    //We are changing the model since we will not be using the same names
    //we are writing the name for the value to be assigned to
    //We are specifying how to process the incoming JSON format.

    @ColumnInfo(name="name") // Regarding the use of Room
    @SerializedName("name")
    val countryName: String?,

    @ColumnInfo(name="region")
    @SerializedName("region")
    val countryRegion: String?,

    @ColumnInfo(name="capital")
    @SerializedName("capital")
    val countryCapital: String?,

    @ColumnInfo(name="currency")
    @SerializedName("currency")
    val countryCurrency: String?,

    @ColumnInfo(name="language")
    @SerializedName("language")
    val countryLanguages: String?,

    @ColumnInfo(name="flag")
    @SerializedName("flag")
    val imageUrl: String?,
){
    @PrimaryKey(autoGenerate = true) //We created a UUID to fetch the data.
    var uuid:Int=0
}
