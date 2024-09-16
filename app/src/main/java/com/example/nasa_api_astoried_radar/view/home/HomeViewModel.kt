package com.example.nasa_api_astoried_radar.view.home

import android.app.Application
import android.util.Log

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.nasa_api_astoried_radar.data.remote.api.Asteroid
import com.example.nasa_api_astoried_radar.data.remote.api.AsteroidServiceNetwork
import com.example.nasa_api_astoried_radar.data.remote.api.Network
import com.example.nasa_api_astoried_radar.data.remote.api.models.ResponseImageOfTheDay
import com.example.nasa_api_astoried_radar.db.AppDatabase
import com.example.nasa_api_astoried_radar.db.ImageOfTheDayEntity
import com.example.nasa_api_astoried_radar.utils.parseAsteroidJsonResult
import kotlinx.coroutines.launch
import org.json.JSONObject


class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val _imageOfTheDay = MutableLiveData<ResponseImageOfTheDay>()
    val imageOfTheDay: LiveData<ResponseImageOfTheDay>
        get() = _imageOfTheDay


    init {
        getImageOfTheDay()
    }

     private fun getImageOfTheDay() {
        viewModelScope.launch {
        val response= Network.imageOfTheDayService.getImageOfTheDay()
          if (response.isSuccessful){
               _imageOfTheDay.postValue(response.body())
            }
        }
    }

}