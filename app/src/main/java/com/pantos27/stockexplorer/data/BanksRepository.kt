package com.pantos27.stockexplorer.data

import com.pantos27.stockexplorer.BuildConfig
import com.pantos27.stockexplorer.data.dto.TimeDataModel
import com.pantos27.stockexplorer.data.dto.TimeInterval
import com.pantos27.stockexplorer.data.dto.TimeSeriesResponse
import com.pantos27.stockexplorer.data.dto.mapToTimeItem
import com.pantos27.stockexplorer.data.retrofit.RetrofitProvider
import com.pantos27.stockexplorer.data.retrofit.TimeSeries
import retrofit2.create

class BanksRepository(private val apikey: String = BuildConfig.API_KEY) {
    private val service: TimeSeries = RetrofitProvider.client.create()

    suspend fun getBankData(symbol: String,interval: TimeInterval): TimeDataModel{
        val response = service.intraday(symbol = symbol, interval = interval.value,apikey = apikey)
        return TimeDataModel(response.metaData.lastRefreshed,response.timeSeries.map { mapToTimeItem(it.key,it.value) })
    }
}