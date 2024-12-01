Android Weather App using MVVM Architecture(ViewModel + LiveData + Kotlin + Retrofit + Coroutine) = Weather App.
1. How to run the App.
  Step-by-Step Guide to Run a Kotlin Android App.
  i. Set Up Android Studio
  Download and Install Android Studio: If you don't have Android Studio installed, visit Android Studio's official website to download and install it, make sure you have the Kotlin plugin enabled.
  ii. Clone the Repository from GitHub
  Go to File > Clone Repository, Enter the repository URL (e.g., https://github.com/username/repository-name.git) and Click Clone and choose the location to save the project on your local machine.
  iii. Open the Project in Android Studio
  Open Android Studio, select Open an existing Android Studio project, Browse to the folder where you cloned the GitHub repository and select it, Android Studio will automatically import the project.
  iv. Sync the Project with Gradle
  Once the project is open in Android Studio, it will start syncing with Gradle automatically. You should see a Gradle Sync notification at the top. If it doesn’t sync automatically, you can manually trigger the sync.
  This step ensures that all dependencies are downloaded and the project is set up properly. You can run app easily.

2. Why made the choices you did.
   When designing an Android weather app or providing guidance on one, I would consider the following aspects for both functionality and user experience.
   i. User-Friendly Interface
   Simple Layout: Weather apps provides essential information quickly and clearly, so a minimalist design works best. Keeping things like temperature, weather condition and humidity on a single screen ensures
   that users don’t get overwhelmed with too much information.
   ii. Accurate and Real-Time Data
   API Choices: Using popular weather API WeatherAPI.com to ensure real-time, accurate weather forecasts and provide the most accurate results.
   iii. Offline Access
   User can see last weather data, if you don’t have an active internet connection or wifi.
   iv. Support for Different Android Versions
   The app designed to work well across multiple Android version. This involves optimizing performance, interface elements, and compatibility for devices running various Android OS versions.
   v. UI/Insrumentation test cases(JUnit, Esspresso)
   Writing UI test cases primarily focused on ensuring the app's functionality, usability, and performance. UI tests help ensure that the app responds correctly to user inputs,
   For instance, if a user clicks a button, the app should perform the action that updating a UI element. For example, verifying that a weather app correctly displays temperature and weather information.

   ![enter_city](https://github.com/user-attachments/assets/50c0d8f6-b0ee-4998-b3b0-9725d1885687) ![weather_data](https://github.com/user-attachments/assets/5d9523e0-2bda-4f3c-a2c1-5abef99f81db) ![offline_data](https://github.com/user-attachments/assets/f0fdc19f-62ad-4465-a4e0-934db8d3a809)
   ![report_UI_test_cases](https://github.com/user-attachments/assets/5f565daf-f81e-43f1-8f69-e0597cd9cffe)



