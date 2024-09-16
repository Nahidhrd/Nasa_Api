package com.example.nasa_api_astoried_radar.data.remote.api


import com.example.nasa_api_astoried_radar.data.remote.api.models.ResponseImageOfTheDay
import com.example.nasa_api_astoried_radar.utils.Constants.API_KEY
import com.example.nasa_api_astoried_radar.utils.Constants.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface AsteroidImageOfTheDayService {
    @GET("planetary/apod")
    suspend fun getImageOfTheDay(@retrofit2.http.Query("api_key") apiKey: String = API_KEY): Response<ResponseImageOfTheDay>
}

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

object Network {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val imageOfTheDayService: AsteroidImageOfTheDayService by lazy {
        retrofit.create(AsteroidImageOfTheDayService::class.java)
    }
}