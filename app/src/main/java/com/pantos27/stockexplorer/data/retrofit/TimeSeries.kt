package com.pantos27.stockexplorer.data.retrofit

import com.pantos27.stockexplorer.data.dto.TimeSeriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TimeSeries {
    @GET("query",)
    suspend fun intraday(@Query("function") function: String = "TIME_SERIES_INTRADAY",
        @Query("symbol") symbol: String,@Query("interval") interval: String,
        @Query("apikey") apikey: String): TimeSeriesResponse

}