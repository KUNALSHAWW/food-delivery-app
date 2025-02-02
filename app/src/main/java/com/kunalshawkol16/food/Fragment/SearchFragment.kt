package com.kunalshawkol16.food.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.kunalshawkol16.food.Adapter.menuadapter
import com.kunalshawkol16.food.R
import com.kunalshawkol16.food.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding : FragmentSearchBinding

    private lateinit var adapter :menuadapter
    private val originalmenufoodname = listOf(
        "Burger",
        "Sandwich",
        "Momo",
        "item","Pizza","Biryani","Panner Masala","Soup"
    )
  private val originalfooditemprice = listOf("$5","$6","$7","$9","$10","$11","$4","$8")
   private val originalmenuitem = listOf(
        R.drawable.burger,
        R.drawable.sandwich,
        R.drawable.momos,
        R.drawable.icon_food,
        R.drawable.pizza,
        R.drawable.biryani,
        R.drawable.panner,
        R.drawable.soup
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
private val filteredmenufoodname = mutableListOf<String>()
private val filteredmenuitemprice= mutableListOf<String>()
private val filteredmenuimage = mutableListOf<Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = menuadapter(filteredmenufoodname,filteredmenuitemprice,filteredmenuimage)
        binding.menurecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.menurecyclerview.adapter = adapter

        // set-up for search view
        setupsearchview()
        // show all menus items
        showallmenu()
        return binding.root

    }
    private fun showallmenu() {
        filteredmenufoodname.clear()
        filteredmenuitemprice.clear()
        filteredmenuimage.clear()

        filteredmenufoodname.addAll(originalmenufoodname)
        filteredmenuitemprice.addAll(originalfooditemprice)
        filteredmenuimage.addAll(originalmenuitem)
        adapter.notifyDataSetChanged()


    }

    private fun setupsearchview() {

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })

    }
    private fun filterMenuItems(query: String) {
        filteredmenufoodname.clear()
        filteredmenuitemprice.clear()
        filteredmenuimage.clear()

        originalmenufoodname.forEachIndexed{index, foodname ->
            if (foodname.contains(query.toString(), ignoreCase = true)){
                filteredmenufoodname.add(foodname)
                filteredmenuitemprice.add(originalfooditemprice[index])
                filteredmenuimage.add(originalmenuitem[index])
            }
        }
        adapter.notifyDataSetChanged()
    }
    companion object {
    }
}