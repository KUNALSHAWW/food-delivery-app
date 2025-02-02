package com.kunalshawkol16.food

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kunalshawkol16.food.Adapter.menuadapter
import com.kunalshawkol16.food.databinding.FragmentMenubottomsheetBinding



class MenubottomsheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenubottomsheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenubottomsheetBinding.inflate(inflater,container,false)

        binding.buttonback.setOnClickListener{
            dismiss()
        }
        val menufoodname = listOf(
        "Burger",
        "Sandwich",
        "Momo",
        "item","Pizza","Biryani","Panner Masala","Soup"
    )
   val menuitemprice = listOf("$5","$6","$7","$9","$10","$11","$4","$8")
    val menuimage = listOf(
        R.drawable.burger,
        R.drawable.sandwich,
        R.drawable.momos,
        R.drawable.icon_food,
        R.drawable.pizza,
        R.drawable.biryani,
        R.drawable.panner,
        R.drawable.soup
    )
        val adapter= menuadapter(
            ArrayList(menufoodname),
            ArrayList(menuitemprice),
            ArrayList(menuimage)
        )
        binding.menurecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.menurecyclerview.adapter = adapter
        return  binding.root
    }

    companion object {

    }
}