package com.magdy.myforecast.data.network.response

import com.magdy.myforecast.data.db.entity.CurrentWeatherEntry
import com.magdy.myforecast.data.db.entity.Location
import com.magdy.myforecast.data.db.entity.Request


data class CurrentWeatherResponse(
    val current: CurrentWeatherEntry,
    val location: Location,
    val request: Request
)