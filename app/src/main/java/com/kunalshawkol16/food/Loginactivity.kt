package com.kunalshawkol16.food

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kunalshawkol16.food.databinding.ActivityLoginactivityBinding


class Loginactivity : AppCompatActivity() {
    private val Binding2 : ActivityLoginactivityBinding by lazy {
        ActivityLoginactivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Binding2.root)
        Binding2.login1button.setOnClickListener {
            val intent = Intent(this, signinactivity::class.java)
            startActivity(intent)
        }
        Binding2.donthavebutton.setOnClickListener {
            val intent = Intent(this,signinactivity::class.java)
            startActivity(intent)
        }
    }
}