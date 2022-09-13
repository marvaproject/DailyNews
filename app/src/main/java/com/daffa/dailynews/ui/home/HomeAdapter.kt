package com.daffa.dailynews.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daffa.dailynews.databinding.FragmentHomeBinding
import com.daffa.dailynews.databinding.RowItemBinding
import com.daffa.dailynews.network.response.HomeResponseItem

class HomeAdapter(private val HomeList: List<HomeResponseItem>) :
    RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder (
        RowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = HomeList[position]
        holder.binding.apply {
            tvCategory.text = data.tag
            tvTitle.text =data.title
            tvDate.text = data.time
            Glide.with(imgNews.context)
                .load(data.thumb)
                .into(imgNews)
        }
    }

    override fun getItemCount(): Int = HomeList.size
}