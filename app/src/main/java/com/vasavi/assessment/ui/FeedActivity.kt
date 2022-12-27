package com.vasavi.assessment.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.vasavi.assessment.R
import com.vasavi.assessment.adapters.FeedAdapter
import com.vasavi.assessment.pojos.FeedResponse
import com.vasavi.assessment.viewmodels.AssessmentViewModel
import kotlinx.android.synthetic.main.activity_news.*

class FeedActivity : AppCompatActivity() {

    lateinit var viewModel: AssessmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        viewModel = ViewModelProvider(this).get(AssessmentViewModel::class.java)

        iv_back.setOnClickListener {
            onBackPressed()
        }

        getNews()

    }

    private fun getNews() {
        viewModel.getNews().observe(this, Observer { response->
            if(response!=null){
                var newsResponse = Gson().fromJson(response, FeedResponse::class.java)
                setAdapter(newsResponse)
            }
        })
    }

    private fun setAdapter(feedResponse : FeedResponse) {
        if(feedResponse.news!=null && feedResponse.news.size>0){
            rv_news.layoutManager = LinearLayoutManager(this)
            rv_news.adapter = FeedAdapter(this, feedResponse.news)
        }
    }
}