package com.magdy.myforecast.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


public class Converters {
    @TypeConverter
    public fun fromString(value: String): MutableList<String> {
        val listType = object : TypeToken<MutableList<String>>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    public fun fromArrayList(list: MutableList<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}