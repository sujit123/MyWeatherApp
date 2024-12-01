package com.example.myweatherapp.data.models

import com.google.gson.annotations.SerializedName

data class Location(@field:SerializedName("country")
                    val country: String? = null,
                    @field:SerializedName("name")
                    val name: String? = null,
                    @field:SerializedName("region")
                    val region: String? = null)
