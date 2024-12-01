package com.example.myweatherapp.data.models

import com.google.gson.annotations.SerializedName

data class Condition(@field:SerializedName("icon")
                     val icon: String? = null,
                     @field:SerializedName("text")
                     val text: String? = null)
