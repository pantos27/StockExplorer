package com.pantos27.stockexplorer.data.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.Reader
import java.text.DateFormat

object RetrofitProvider {
    const val HOST = "https://www.alphavantage.co/"
    val gson: Gson = GsonBuilder().create()
    val client: Retrofit = Retrofit.Builder()
            .baseUrl(HOST)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

}
inline fun <reified T> Gson.fromJson(reader: Reader) = fromJson<T>(reader, object: TypeToken<T>() {}.type)