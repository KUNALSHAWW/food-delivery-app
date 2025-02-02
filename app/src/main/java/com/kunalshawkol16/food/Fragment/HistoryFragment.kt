package com.kunalshawkol16.food.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kunalshawkol16.food.Adapter.BuyAgainAdapter
import com.kunalshawkol16.food.R
import com.kunalshawkol16.food.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    private lateinit var binding :FragmentHistoryBinding
    private lateinit var  buyagainadapter : BuyAgainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
       setuprecyclerview()
        return binding.root
    }
private fun setuprecyclerview(){
   val buyagainfoodname = arrayListOf("Pizza","Momo","Burger")
   val buyagainfoodprice = arrayListOf("$8","$7","$9")
   val buyagainfoodimage = arrayListOf(R.drawable.pizza,R.drawable.momos,R.drawable.burger)
    buyagainadapter = BuyAgainAdapter(buyagainfoodname,buyagainfoodprice,buyagainfoodimage)
    binding.buyagainrecyclerview.adapter = buyagainadapter
    binding.buyagainrecyclerview.layoutManager = LinearLayoutManager(requireContext())


}
    companion object {

}
}