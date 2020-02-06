package com.magdy.myforecast.data.network

import androidx.lifecycle.LiveData
import com.magdy.myforecast.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather : LiveData<CurrentWeatherResponse>
    suspend fun fetchCurrentWeather(
        location:String,
        units:String
    )
}