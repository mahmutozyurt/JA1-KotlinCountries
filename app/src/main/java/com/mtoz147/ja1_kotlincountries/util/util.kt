package com.mtoz147.ja1_kotlincountries.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mtoz147.ja1_kotlincountries.R

//https://developer.android.com/kotlin/ktx

// extension
// You can write the class in which you want to make the extension.For example String class.

/*
fun String.myExtension(myParameter:String){
    println(myParameter)
}*/

//Defining a function for Glide on every created ImageView object,
// setting Glide configurations within that function,
// and being able to call that function on any ImageView to access it again by defining it once.

//https://github.com/bumptech/glide

fun ImageView.downloadFromUrl(url:String?,progressDrawable: CircularProgressDrawable){
//What will be displayed until the image loads,
// For example a progress bar will be displayed.
    val options=RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher_round) //What will happen in case of an error?

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}

fun placeHolderProgressBar(context:Context):CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        strokeWidth=8f
        centerRadius=40f
        start()
    }
}