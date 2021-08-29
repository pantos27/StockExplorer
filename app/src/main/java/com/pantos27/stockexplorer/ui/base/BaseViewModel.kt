package com.pantos27.stockexplorer.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

abstract class BaseViewModel: ViewModel() {
    lateinit var navController: NavController
    protected val _error = MutableLiveData<Exception>()
    val error: LiveData<Exception> = _error
}
