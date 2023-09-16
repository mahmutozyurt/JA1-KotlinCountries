package com.mtoz147.ja1_kotlincountries.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel(application: Application) :AndroidViewModel(application),CoroutineScope{

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() =job+Dispatchers.Main //It does its job first and then returns to the main thread.

    override fun onCleared() {
        //If something is destroyed, for example, if the application is closed, the task is canceled.
        super.onCleared()
        job.cancel()
    }


}
