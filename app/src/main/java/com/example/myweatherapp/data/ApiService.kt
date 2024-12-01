package com.example.myweatherapp.data

import com.example.myweatherapp.data.models.CurrentWeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("current.json")
     fun getCurrentWeather(
        @Query("key") key: String = ApiConfig.API_KEY,
        @Query("q") city: String,
        @Query("aqi") aqi: String = "no"
    ): Call<CurrentWeatherResponse>
}