package com.kunalshawkol16.food.Fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.kunalshawkol16.food.R

class profileFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editTextName: EditText
    private lateinit var editTextAddress: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var button2: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Initialize Views
        editTextName = view.findViewById(R.id.editname) // Replace with the correct ID
        editTextAddress = view.findViewById(R.id.editaddress) // Replace with the correct ID
        editTextEmail = view.findViewById(R.id.editemail) // Replace with the correct ID
        editTextPhone = view.findViewById(R.id.editnumber) // Replace with the correct ID
        button2 = view.findViewById(R.id.button2)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize SharedPreferences
        sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)

        // Load saved values
        loadSavedValues()

        // Button click listener
        button2.setOnClickListener {
            // Save the edited values
            saveValues()
        }
    }

    private fun loadSavedValues() {
        // Load saved values from SharedPreferences
        val name = sharedPreferences.getString(KEY_NAME, "KUNAL SHAW") ?: ""
        val address = sharedPreferences.getString(KEY_ADDRESS, "B-6\nFEDERAL PUBLIC SCHOOL\nRAICHUR , KARNATKA") ?: ""
        val email = sharedPreferences.getString(KEY_EMAIL, "cs23b1039@iiitr.ac.in") ?: ""
        val phone = sharedPreferences.getString(KEY_PHONE, "6290308120") ?: ""

        // Set values to EditText views
        editTextName.setText(name.replace("&#10;", "\n"))
        editTextAddress.setText(address.replace("&#10;", "\n"))
        editTextEmail.setText(email)
        editTextPhone.setText(phone)
    }

    private fun saveValues() {
        // Save the edited values to SharedPreferences
        with(sharedPreferences.edit()) {
            putString(KEY_NAME, editTextName.text.toString())
            putString(KEY_ADDRESS, editTextAddress.text.toString())
            putString(KEY_EMAIL, editTextEmail.text.toString())
            putString(KEY_PHONE, editTextPhone.text.toString())
            apply()
        }
        // You can also show a toast or perform any other action upon saving if needed
    }

    companion object {
        // Define keys for SharedPreferences
        private const val KEY_NAME = "name"
        private const val KEY_ADDRESS = "address"
        private const val KEY_EMAIL = "email"
        private const val KEY_PHONE = "phone"
    }
}
