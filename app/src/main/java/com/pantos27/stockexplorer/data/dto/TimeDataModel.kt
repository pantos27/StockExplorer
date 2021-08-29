package com.pantos27.stockexplorer.data.dto

data class TimeDataModel(val lastRefresh: String, val timeItems: List<TimeItemModel>)

data class TimeItemModel(
    val time: String,
    val open: Double,
    val high: Double,
    val low: Double,
    val close: Double,
    val volume: Int
){
    override fun toString(): String {
        return """
            Time: $time
            Open: $open Close: $close
            High: $high Low: $low
            Volume: $volume"""
    }
}

fun mapToTimeItem(time: String, timeData: TimeData): TimeItemModel {
    return TimeItemModel(
        time,
        timeData.open,
        timeData.high,
        timeData.low,
        timeData.close,
        timeData.volume
    )
}