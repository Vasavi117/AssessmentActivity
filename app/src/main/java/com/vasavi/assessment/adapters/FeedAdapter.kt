package com.vasavi.assessment.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vasavi.assessment.R
import com.vasavi.assessment.pojos.NewsItem
import kotlinx.android.synthetic.main.list_item_news.view.*
import java.text.DateFormat
import java.text.ParseException
import java.text.ParsePosition
import java.text.SimpleDateFormat
import java.util.*


class FeedAdapter(var mContext: Context, var articles: List<NewsItem>) :
    RecyclerView.Adapter<FeedAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.list_item_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = articles[position]
        if(data.image!=null && data.image.isNotEmpty()){
            Picasso.get().load(data.image).into(holder.itemView.iv_news_image)
        }
        holder.itemView.tv_date.text = getTime(data.publishDate)
        holder.itemView.tv_title.text = data.title
        holder.itemView.tv_desc.text = data.text
        holder.itemView.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(data.url))
            mContext.startActivity(browserIntent)
        }
    }

    override fun getItemCount(): Int {
       return articles.size
    }

    @Throws(ParseException::class)
    fun getTime(date: String): String{
        var time = ""
        val arrCal = Calendar.getInstance()
        arrCal.time = stringToDate(date, "yyyy-MM-dd HH:mm:ss")
        time = DateFormat.getDateInstance().format(arrCal.time)
        return time
    }

    private fun stringToDate(aDate: String?, aFormat: String): Date? {
        if (aDate == null) return null
        val pos = ParsePosition(0)
        val simpledateformat = SimpleDateFormat(aFormat)
        return simpledateformat.parse(aDate, pos)
    }


}
