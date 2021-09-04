package com.ognjenlazic.testing

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_saving_data.*

class SavingData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saving_data)

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)

        val editor = sharedPref.edit()

        btnSave.setOnClickListener {
            val name = editName.text.toString()
            val age = editAge.text.toString().toInt()
            val isAdult = checkAdult.isChecked

            editor.apply {
                putString("name", name)
                putInt("age", age)
                putBoolean("isAdlut", isAdult)
                apply()
            }
        }

        btnLoad.setOnClickListener {
            val name = sharedPref.getString("name", null)
            val age = sharedPref.getInt("age", 0)
            val isAdult = sharedPref.getBoolean("isAdult", false)

            editName.setText(name)
            editAge.setText(age.toString())
            checkAdult.isChecked = isAdult
        }

    }
}
