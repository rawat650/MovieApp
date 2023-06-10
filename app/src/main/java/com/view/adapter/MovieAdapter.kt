package com.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.techbulltask.databinding.MovieViewBinding
import com.model.MovieData

class MovieAdapter(val context:Context,val list:List<MovieData>):RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    class MovieViewHolder(binding: MovieViewBinding):RecyclerView.ViewHolder(binding.root){
        val txtName = binding.txtName
        val txtYear = binding.txtYear
        val imgView = binding.imgView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MovieViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
       val data = list[position]
        holder.txtName.setText(data.Title)
        holder.txtYear.setText(data.Year)
        Glide.with(context).load(data.Poster).into(holder.imgView)
    }
}