package com.magdy.myforecast.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.magdy.myforecast.data.network.response.CurrentWeatherResponse
import com.magdy.myforecast.internal.NoConnectionException

class WeatherNetworkDataSourceImpl(
    private val apiService: ApiService
) : WeatherNetworkDataSource {
    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String, units: String) {
        try {
            val fetchedCurrentWeather = apiService
                .getCurrentWeahter(location, units)
                .await()
            _downloadedCurrentWeather.postValue(fetchedCurrentWeather)
        }
        catch (e:NoConnectionException)
        {
            Log.e("my forecast","no internet connection",e)
        }
    }
}