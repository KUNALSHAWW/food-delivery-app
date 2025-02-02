package com.kunalshawkol16.food.Adapter

import android.util.SparseArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kunalshawkol16.food.databinding.CartItemBinding

class cartadapter(
    private val cartItems: MutableList<String>,
    private val Cartitemprice: MutableList<String>,
    private var CartImage: MutableList<Int>
) : RecyclerView.Adapter<cartadapter.Cartviewholder>() {

    private val itemQuantities = SparseArray<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Cartviewholder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Cartviewholder(binding)
    }

    override fun getItemCount(): Int = cartItems.size

    override fun onBindViewHolder(holder: Cartviewholder, position: Int) {
        holder.bind(position)
    }

    inner class Cartviewholder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.minusbutton.setOnClickListener {
                decreaseQuantity(adapterPosition)
            }

            binding.plusbutton.setOnClickListener {
                increaseQuantity(adapterPosition)
            }

            binding.deletebutton.setOnClickListener {
                deleteItem(adapterPosition)
            }
        }

        fun bind(position: Int) {
            binding.apply {
                cartfoodname.text = cartItems[position]
                cartitemprice.text = Cartitemprice[position]
                cartimage.setImageResource(CartImage[position])

                // Initialize quantity for the item position
                val quantity = itemQuantities[position, 1]
                this@apply.quantity.text = quantity.toString()
            }
        }

        private fun decreaseQuantity(position: Int) {
            val currentQuantity = itemQuantities.get(position, 1)
            if (currentQuantity > 1) {
                itemQuantities.put(position, currentQuantity - 1)
                binding.quantity.text = (currentQuantity - 1).toString()
            }
        }

        private fun deleteItem(position: Int) {
            itemQuantities.remove(position)
            cartItems.removeAt(position)
            CartImage.removeAt(position)
            Cartitemprice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartItems.size)
        }

        private fun increaseQuantity(position: Int) {
            val currentQuantity = itemQuantities.get(position, 1)
            if (currentQuantity < 10) {
                itemQuantities.put(position, currentQuantity + 1)
                binding.quantity.text = (currentQuantity + 1).toString()
            }
        }
    }
}
