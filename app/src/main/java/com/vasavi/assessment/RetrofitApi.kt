package com.vasavi.assessment

import com.google.gson.JsonObject
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface RetrofitApi {

    @Headers("Content-Type: application/json")
    @GET
    fun getNews(@Url response: String): Call<JsonObject>

    @Multipart
    @POST("upload")
    fun uploadMultipleFiles(
        @Part surveyImage: Array<MultipartBody.Part?>,
        @Part("DRA") response: JsonObject
    ): Call<JsonObject>
}