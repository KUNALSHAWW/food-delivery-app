package com.kunalshawkol16.food.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kunalshawkol16.food.databinding.BuyAgainItemBinding
import com.kunalshawkol16.food.databinding.PopularItemBinding

class BuyAgainAdapter(private val buyAgainFoodName: ArrayList<String>,private val buyagainFoodPrice :ArrayList<String>,private val buyagainFoodImage : ArrayList<Int>) : RecyclerView.Adapter<BuyAgainAdapter.BuyagainViewHolder>() {

    override fun onBindViewHolder(holder: BuyagainViewHolder, position: Int) {
    holder.bind(buyAgainFoodName[position],buyagainFoodPrice[position],buyagainFoodImage[position])
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyagainViewHolder {
       val binding = BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BuyagainViewHolder(binding)
    }

    override fun getItemCount(): Int = buyAgainFoodName.size
    class BuyagainViewHolder (private val binding: BuyAgainItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(foodname: String, foodprice: String, foodimage: Int) {
            binding.buyagainfoodname.text = foodname
            binding.buyagainfoodprice.text = foodprice
            binding.buyagainfoodimage.setImageResource(foodimage)

        }

    }


}