package com.vasavi.assessment.viewmodels

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.JsonObject
import com.vasavi.assessment.repos.AssessmentRepository

class AssessmentViewModel : ViewModel() {

    var assessmentRepository = AssessmentRepository()

    fun getNews() : LiveData<JsonObject>{
        return assessmentRepository.getNews()
    }

    fun uploadFiles(filesList: ArrayList<Uri>) : MutableLiveData<JsonObject> {
        return assessmentRepository.uploadFiles(filesList)
    }
}