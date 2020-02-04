package com.magdy.myforecast.data.db.entity


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.magdy.myforecast.data.Converters

const val CURRENT_WEATHER_ID = 0

@Entity(tableName = "current_weather")
data class CurrentWeatherEntry(
    val feelslike: Int,
    @SerializedName("observation_time")
    val observationTime: String,
    val precip: Int,
    val temparature: Double,
    val visibility: Int,
    @SerializedName("weather_code")
    val weatherCode: Int,
    @TypeConverters(Converters::class)
    @SerializedName("weather_descriptions")
    val weatherDescriptions: List<String>,
    @TypeConverters(Converters::class)
    @SerializedName("weather_icons")
    val weatherIcons: List<String>,
    @SerializedName("wind_degree")
    val windDegree: Int,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("wind_speed")
    val windSpeed: Int
)
{
    @PrimaryKey(autoGenerate = false)
    var id  : Int = CURRENT_WEATHER_ID
}