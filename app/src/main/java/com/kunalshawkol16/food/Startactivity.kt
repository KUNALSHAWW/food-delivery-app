package com.kunalshawkol16.food

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import com.kunalshawkol16.food.databinding.ActivityStartBinding

class Startactivity : AppCompatActivity() {
    private val Binding1 :ActivityStartBinding by lazy {
        ActivityStartBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Binding1.root)
        Binding1.buttonnext.setOnClickListener{
            val intent = Intent(this,Loginactivity::class.java)
            startActivity(intent)
        }
    }
}


