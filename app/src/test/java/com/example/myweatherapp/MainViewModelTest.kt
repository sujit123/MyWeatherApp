package com.example.myweatherapp

import com.example.myweatherapp.viewmodel.MainViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {
    @get:Rule
    lateinit var mainViewModel: MainViewModel

    @Before
    fun before() {
        mainViewModel = MainViewModel()
    }

    @Test
    fun onFetchWeatherButtonClick() {
        mainViewModel.getWeatherData("Mumbai")
    }
}