package com.kunalshawkol16.food.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kunalshawkol16.food.databinding.PopularItemBinding

class popularadapter(private  val items:List<String>,private val price :List<String>,private val image :List<Int>) :RecyclerView.Adapter<popularadapter.popularviewholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): popularviewholder {
        return popularviewholder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }



    override fun onBindViewHolder(holder: popularviewholder, position: Int) {
        val item = items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(item,price,images)
    }
    override fun getItemCount(): Int {
        return items.size
    }
    class popularviewholder (private val binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root){
        private val imagesview =binding.imageView
        fun bind(item: String, price: String, images: Int) {
            binding.Foodnamepopular.text = item
            binding.pricepopular.text = price
            imagesview.setImageResource(images)

        }

    }
}