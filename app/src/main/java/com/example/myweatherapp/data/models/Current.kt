package com.example.myweatherapp.data.models

import com.google.gson.annotations.SerializedName

data class Current(@field:SerializedName("temp_c")
                   val tempC: Double? = null,
                   @field:SerializedName("temp_f")
                   val tempF: Double? = null,
                   @field:SerializedName("condition")
                   val condition: Condition? = null,
                   @field:SerializedName("humidity")
                   val humidity: Double? = null)
