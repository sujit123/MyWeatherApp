package com.example.myweatherapp.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myweatherapp.R
import com.example.myweatherapp.data.models.CurrentWeatherResponse
import com.example.myweatherapp.databinding.ActivityMainBinding
import com.example.myweatherapp.utils.SharedPreferencesManager
import com.example.myweatherapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    val resultText = StringBuilder()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel = MainViewModel()
        SharedPreferencesManager.init(this)
        subscribe()

        binding.btnFetchWeather.setOnClickListener {
            if (binding.etCityName.text.isNullOrEmpty() or binding.etCityName.text.isNullOrBlank()) {
                binding.etCityName.error = resources.getString(R.string.pls_enter_city)
            } else {
                mainViewModel.getWeatherData(binding.etCityName.text.toString())
            }
        }
    }

    private fun subscribe() {
        mainViewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) binding.tvResult.text = resources.getString(R.string.loading)
        }

        mainViewModel.isError.observe(this) { isError ->
            if (isError) {
                binding.imgCondition.visibility = View.GONE
                if(SharedPreferencesManager.isNetworkAvailable(this) || !SharedPreferencesManager.sharedPreferences.all.containsKey("condition_key")){
                    binding.tvResult.text = mainViewModel.errorMessage
                }else{
                    resultText.append("Offline last weather data :-\n")
                    setResultImage(SharedPreferencesManager.getString("icon_key", ""))
                    resultText.append(resources.getString(R.string.condition)+" "+"${SharedPreferencesManager.getString("condition_key", "")}\n")
                    resultText.append(resources.getString(R.string.temperature)+" "+"${SharedPreferencesManager.getString("temp_key", "")}\n")
                    resultText.append(resources.getString(R.string.humidity)+" "+"${SharedPreferencesManager.getString("humidity_key", "")}\n")
                    binding.tvResult.text = resultText
                    resultText.setLength(0)
                }
            }
        }

        mainViewModel.weatherData.observe(this) { weatherData ->
            SharedPreferencesManager.editor?.clear()
            SharedPreferencesManager.editor?.apply()
            if(!SharedPreferencesManager.sharedPreferences.all.containsKey("condition_key")){
                SharedPreferencesManager.saveString("condition_key", weatherData.current?.condition?.text.toString())
                SharedPreferencesManager.saveString("icon_key", weatherData.current?.condition?.icon.toString())
                SharedPreferencesManager.saveString("temp_key", weatherData.current?.tempC.toString())
                SharedPreferencesManager.saveString("humidity_key", weatherData.current?.humidity.toString())
            }
            setResultText(weatherData)
        }
    }

    private fun setResultText(weatherData: CurrentWeatherResponse) {
        weatherData.location.let { location ->
                resultText.append(resources.getString(R.string.name)+" "+"${location?.name}\n")
                resultText.append(resources.getString(R.string.region)+" "+"${location?.region}\n")
                resultText.append(resources.getString(R.string.country)+" "+"${location?.country}\n")
        }

        weatherData.current.let { current ->
            current?.condition.let { condition ->
                resultText.append(resources.getString(R.string.condition)+" "+"${condition?.text}\n")
                setResultImage(condition?.icon)
            }
            resultText.append(resources.getString(R.string.temperature)+" "+"${current?.tempC}\n")
            resultText.append(resources.getString(R.string.humidity)+" "+"${current?.humidity}\n")
        }
        binding.tvResult.text = resultText
        resultText.setLength(0)
    }

    private fun setResultImage(imageUrl: String?) {
        imageUrl.let { url ->
            Glide.with(applicationContext)
                .load("https:$url")
                .into(binding.imgCondition)

            binding.imgCondition.visibility = View.VISIBLE
            return
        }
        binding.imgCondition.visibility = View.GONE
    }
}