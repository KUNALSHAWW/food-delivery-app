package com.kunalshawkol16.food.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kunalshawkol16.food.databinding.MenuItemBinding

class menuadapter(private val menuitems: List<String>, private val menuitemprice: List<String>, private val menuimage: List<Int>): RecyclerView.Adapter<menuadapter.Menuviewholder>() {


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Menuviewholder {
     val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Menuviewholder(binding)
    }

    override fun onBindViewHolder(holder: menuadapter.Menuviewholder, position: Int) {
       holder.bind(position)
    }

    override fun getItemCount(): Int = menuitems.size
    inner  class Menuviewholder(private val binding: MenuItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                menuFoodname.text = menuitems[position]
                menuprice.text = menuitemprice[position]
                Menuimage.setImageResource(menuimage[position])
            }
        }

    }

}


