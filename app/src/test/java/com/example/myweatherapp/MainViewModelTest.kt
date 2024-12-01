package com.example.myweatherapp

import android.app.Application
import com.example.myweatherapp.view.MainActivity
import com.example.myweatherapp.viewmodel.MainViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class MainViewModelTest {
    @get:Rule
    //val rule = InstantTaskExecutorRule()
    lateinit var mainViewModel: MainViewModel
    var app: Application = mock()
    var mainActivity = MainActivity()

    @Before
    fun before() {
        mainViewModel = MainViewModel()
        //activateCardSuccessViewModel.mContext = app
    }

    @Test
    fun onActivateCardSuccessButtonClick() {
        mainViewModel.getWeatherData("Mumbai")
    }

}