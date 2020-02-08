package com.magdy.myforecast.data.repository

import androidx.lifecycle.LiveData
import com.magdy.myforecast.data.db.entity.CurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather():LiveData<CurrentWeatherEntry>
}