package com.kunalshawkol16.food.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kunalshawkol16.food.Adapter.cartadapter
import com.kunalshawkol16.food.R
import com.kunalshawkol16.food.databinding.FragmentCartBinding


class CartFragment : Fragment() {
private lateinit var binding : FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater,container,false)
        val cartfoodname = listOf("Burger","Sandwich","momo","item")
        val cartitemprice = listOf("$5","$7","$8","$9")
        val cartimage = listOf(
            R.drawable.burger,
            R.drawable.sandwich,
            R.drawable.momos,
            R.drawable.icon_food
        )
        val adapter = cartadapter(ArrayList(cartfoodname),ArrayList(cartitemprice),ArrayList(cartimage))
        binding.cartrecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.cartrecyclerview.adapter = adapter

        return binding.root
    }

    companion object {

    }
}