package com.mtoz147.ja1_kotlincountries.model

import com.google.gson.annotations.SerializedName

data class Country(
    //We are changing the model since we will not be using the same names
    //we are writing the name for the value to be assigned to
    //We are specifying how to process the incoming JSON format.

    @SerializedName("name")
    val countryName: String?,
    @SerializedName("region")
    val countryRegion: String?,
    @SerializedName("capital")
    val countryCapital: String?,
    @SerializedName("currency")
    val countryCurrency: String?,
    @SerializedName("language")
    val countryLanguages: String?,
    @SerializedName("flag")
    val imageUrl: String?,
)
