package com.vasavi.assessment.network

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkUtils {

    fun retrofitClient(connTimeout: Long, serviceBaseUrl: String, gson: Gson): Retrofit {

        val client = OkHttpClient.Builder()
            .connectTimeout(connTimeout, TimeUnit.SECONDS)
            .readTimeout(connTimeout, TimeUnit.SECONDS).build()
        return Retrofit.Builder()
            .baseUrl(serviceBaseUrl).client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}