package com.kunalshawkol16.food.Fragment

import android.os.Bundle
import android.os.TestLooperManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView.ScaleType
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.kunalshawkol16.food.Adapter.popularadapter
import com.kunalshawkol16.food.MenubottomsheetFragment
import com.kunalshawkol16.food.R
import com.kunalshawkol16.food.databinding.ActivityChooselocationactivityBinding
import com.kunalshawkol16.food.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
private lateinit var binding : FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.Viewallmenu.setOnClickListener{
            val bottomSheetDialog = MenubottomsheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imagelist = ArrayList<SlideModel>()
        imagelist.add(SlideModel(R.drawable.banner1,ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.ban2,ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.ban3,ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imagelist)
        imageSlider.setImageList(imagelist,ScaleTypes.FIT)

        val fooditems= listOf("Burger","sandwich","momo","item")
        val price = listOf("$5","$7","$8","$9")
        val popularfoodimages = listOf(R.drawable.burger,R.drawable.sandwich,R.drawable.momos,R.drawable.icon_food)

        val adapter = popularadapter(fooditems,price,popularfoodimages)
        binding.popularrecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.popularrecyclerview.adapter = adapter
    }

    companion object {

    }
}