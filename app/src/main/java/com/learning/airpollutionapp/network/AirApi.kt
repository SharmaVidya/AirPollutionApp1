package com.learning.airpollutionapp.network
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val baseUrl = "http://api.openweathermap.org/data/2.5/";

private val retrofit = Retrofit.Builder()
    .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface WeatherApiService {
    @GET("coord")
    suspend fun getAirData(
        @Query("q") lat: Double,
        @Query("r") lon: Double,
        @Query("appid") apiKey: String,
    ): AirResponse
}

object AirApi {
    val retrofitService: WeatherApiService by lazy {
        retrofit.create(WeatherApiService::class.java)
    }
}