package com.pantos27.stockexplorer.ui.bankdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.pantos27.stockexplorer.data.BanksRepository
import com.pantos27.stockexplorer.data.dto.Bank
import com.pantos27.stockexplorer.data.dto.TimeDataModel
import com.pantos27.stockexplorer.data.dto.TimeInterval
import com.pantos27.stockexplorer.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class BankDetailsViewModel: BaseViewModel() {
    val repo = BanksRepository()
    private val _bankData = MutableLiveData<TimeDataModel>()
    val bankData: LiveData<TimeDataModel> = _bankData



    fun getBankData(bank: Bank) = viewModelScope.launch {
        try {
            val response = repo.getBankData(bank.stk,TimeInterval.OneMinute)
            _bankData.value = response

        }catch (e: Exception){
            _error.value = e
        }
    }
}