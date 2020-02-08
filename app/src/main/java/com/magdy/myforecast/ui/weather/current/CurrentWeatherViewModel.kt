package com.magdy.myforecast.ui.weather.current

import androidx.lifecycle.ViewModel
import com.magdy.myforecast.data.repository.ForecastRepository
import com.magdy.myforecast.internal.UnitSystem
import com.magdy.myforecast.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {
    private val unitSystem = UnitSystem.METRIC //get from settings later

    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeferred {
         forecastRepository.getCurrentWeather()
    }
}
