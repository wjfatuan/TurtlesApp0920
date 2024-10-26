package com.example.turtlesapp0920.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApiService {

    @GET("images/search")
    suspend fun search(@Query("limit") limit: Int = 1): List<Cat>



    companion object {
        const val BASE_URL = "https://api.thecatapi.com/v1/"
        fun getInstance(): CatApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CatApiService::class.java)
        }
    }


}