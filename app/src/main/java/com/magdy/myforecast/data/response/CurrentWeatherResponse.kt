package com.magdy.myforecast.data.response


data class CurrentWeatherResponse(
    val current: CurrentWeatherEntry,
    val location: Location,
    val request: Request
)