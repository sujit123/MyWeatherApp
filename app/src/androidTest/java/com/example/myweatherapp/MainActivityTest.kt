package com.example.myweatherapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myweatherapp.view.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.test.rule.ActivityTestRule
import com.example.myweatherapp.viewmodel.MainViewModel
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var activityActivityTestRule = ActivityTestRule(MainActivity::class.java)
    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setUp() {
        mainViewModel = MainViewModel()
    }

    @Test
    fun checkFetchWeatherBtn() {
        onView(withId(R.id.btn_fetch_weather))
            .perform(click())
    }

    @Test
    fun checkFetchWeatherBtnText() {
        onView(withId(R.id.btn_fetch_weather))
            .check(ViewAssertions.matches(ViewMatchers.withText("Fetch current weather")))
    }

    @Test
    fun checkFetchWeatherBtnTextColor() {
        onView(withId(R.id.btn_fetch_weather))
            .check(ViewAssertions.matches(ViewMatchers.hasTextColor(R.color.white)))
    }

    @Test
    fun checkFetchWeatherResultText() {
        onView(withId(R.id.tv_result))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    @Test
    fun checkEnterCityNameText() {
        onView(withId(R.id.et_city_name))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }
}