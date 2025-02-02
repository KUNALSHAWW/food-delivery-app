package com.kunalshawkol16.food

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kunalshawkol16.food.databinding.ActivityChooselocationactivityBinding
import com.kunalshawkol16.food.databinding.ActivityLoginactivityBinding
import com.kunalshawkol16.food.databinding.ActivityMainBinding
import com.kunalshawkol16.food.databinding.ActivitySigninactivityBinding

class signinactivity : AppCompatActivity() {
    private val binding: ActivitySigninactivityBinding by lazy {
        ActivitySigninactivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.login2button.setOnClickListener {
            val intent = Intent(this, chooselocationactivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.alreadybutton.setOnClickListener {
            val intent = Intent(this, Loginactivity::class.java)
            startActivity(intent)
        }
    }
}
