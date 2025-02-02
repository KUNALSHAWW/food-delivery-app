package com.kunalshawkol16.food

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.kunalshawkol16.food.databinding.ActivityChooselocationactivityBinding
import com.kunalshawkol16.food.databinding.ActivityMainBinding


class chooselocationactivity : AppCompatActivity() {
    private val binding: ActivityChooselocationactivityBinding by lazy {
        ActivityChooselocationactivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.donebutton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val locationlist = arrayOf("KOLKATA", "HYDERABAD", "BANGALORE", "RAICHUR")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, locationlist)

        binding.listoflocation.setAdapter(adapter)
    }
}
