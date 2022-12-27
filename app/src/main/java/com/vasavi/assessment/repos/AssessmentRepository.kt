package com.vasavi.assessment.repos

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.vasavi.assessment.network.NetworkUtils
import com.vasavi.assessment.RetrofitApi
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class AssessmentRepository {

    fun getNews(): MutableLiveData<JsonObject>{
        val data = MutableLiveData<JsonObject>()
        val connTime = 20L

        val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create()
        val serviceUrl = "https://newsapi.org/v2/"
        val url = "https://api.worldnewsapi.com/search-news?api-key=22c945d2a2684269b88b2e8fc76c1ae0&text=tesla&number=100"
        val retrofit = NetworkUtils().retrofitClient(connTime, serviceUrl, gson)
        val github = retrofit.create(RetrofitApi::class.java)
        val call = github.getNews(url)
        call.enqueue(object : Callback<JsonObject>{
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if(response.isSuccessful){
                    data.value = response.body()
                }else{
                    data.value = null
                }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
               data.value = null
            }

        })
        return data
    }

    fun uploadFiles(filesList: ArrayList<Uri>): MutableLiveData<JsonObject> {
        var data = MutableLiveData<JsonObject>()
        val connTimeout = 100L
        val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create()
        val serviceBaseUrl = "https://newsapi.org/v2/"

        val retrofit = NetworkUtils().retrofitClient(connTimeout, serviceBaseUrl, gson)
        val github = retrofit.create(RetrofitApi::class.java)

        val uploadImaheParts = arrayOfNulls<MultipartBody.Part>(filesList.size)
        for (index in filesList.indices) {
            val file = File(filesList[index].path)
            val surveyBody = RequestBody.create(
                "image/*".toMediaTypeOrNull(),
                file
            )
            uploadImaheParts[index] = MultipartBody.Part.createFormData("upload_image",
                file.getName(),
                surveyBody);
        }

        val jsonObject = JsonObject()
        jsonObject.addProperty("name", "Vasavi")

        val call = github.uploadMultipleFiles(uploadImaheParts, jsonObject)
        call.enqueue(object : Callback<JsonObject> {
            override fun onResponse(
                call: Call<JsonObject>,
                response: Response<JsonObject>
            ) {
                if (response.isSuccessful) {
                    data.value = response.body()
                } else {
                    data.value = null
                }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                data.value = null
            }
        })

        return data
    }
}
