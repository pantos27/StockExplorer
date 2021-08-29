package com.pantos27.stockexplorer.data.dto

import com.google.gson.annotations.SerializedName

data class TimeSeriesResponse(
    @SerializedName("Meta Data") val metaData: MetaData,
    @SerializedName(value = "Time Series (1min)",
        alternate = ["Time Series (5min)", "Time Series (15min)","Time Series (30min)","Time Series (60min)"]
    ) val timeSeries: Map<String,TimeData>
)

data class MetaData(
    @SerializedName("1. Information") val information: String,
    @SerializedName("2. Symbol") val symbol: String,
    @SerializedName("3. Last Refreshed") val lastRefreshed: String,
    @SerializedName("4. Interval") val interval: String,
    @SerializedName("6. Time Zone") val timeZone: String
)

data class TimeData(
    @SerializedName("1. open") val open: Double,
    @SerializedName("2. high") val high: Double,
    @SerializedName("3. low") val low: Double,
    @SerializedName("4. close") val close: Double,
    @SerializedName("5. volume") val volume: Int
)