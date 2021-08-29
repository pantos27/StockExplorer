package com.pantos27.stockexplorer.data

import android.content.res.AssetManager
import com.pantos27.stockexplorer.data.dto.Bank
import com.pantos27.stockexplorer.data.retrofit.RetrofitProvider
import com.pantos27.stockexplorer.data.retrofit.fromJson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AssetsRepository {

    suspend fun getAllBanks(assetManager: AssetManager): List<Bank> = withContext(Dispatchers.IO){
        return@withContext RetrofitProvider.gson.fromJson(assetManager.open("stocks.json").bufferedReader())
    }

}