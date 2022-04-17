package com.ashutosh1234ojha.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ashutosh1234ojha.jetpackcompose.R
import com.bumptech.glide.Glide
import com.ashutosh1234ojha.paging.data.Hit

/**
 * Created by Ashutosh Ojha on 05,January,2022
 */
class PhotoAdapter : PagingDataAdapter<Hit, PhotoAdapter.ViewHolder>(DataDiff) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(holder.image.context).load(getItem(position)?.largeImageURL).into(holder.image);

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent, false)
        )
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val image = view.findViewById<AppCompatImageView>(R.id.imageView)
    }

    object DataDiff : DiffUtil.ItemCallback<Hit>() {
        override fun areItemsTheSame(oldItem: Hit, newItem: Hit): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Hit, newItem: Hit): Boolean {
            return oldItem.id == newItem.id
        }

    }
}