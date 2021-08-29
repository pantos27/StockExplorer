package com.pantos27.stockexplorer.ui.main

import android.content.res.AssetManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.pantos27.stockexplorer.data.AssetsRepository
import com.pantos27.stockexplorer.data.dto.Bank
import com.pantos27.stockexplorer.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : BaseViewModel() {

    private val repository = AssetsRepository()
    private val _banks = MutableLiveData<List<Bank>>()
    val banks: LiveData<List<Bank>> = _banks

    fun getData(assetManager: AssetManager){
        viewModelScope.launch {
            try {
                val list = repository.getAllBanks(assetManager)
                _banks.value = list.sortedByDescending { it.priority }
            }catch (e: Exception){
                _error.value = e
            }

        }
    }

    fun bankClicked(bank: Bank) {
        val action =
            MainFragmentDirections.actionMainToBankDetailsFragment(bank)
        navController.navigate(action)
    }
}