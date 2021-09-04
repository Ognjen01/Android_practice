package com.ognjenlazic.testing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_passing1.*

class Passing1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passing1)

        pass.setOnClickListener {
            Intent(this, Passing2 :: class.java).also {

                val name =  name.toString()
                val secondName = secondName.toString()
                val  age = year.toString()
                val cou = country.toString()

                it.putExtra("Name", name)
                it.putExtra("Second", secondName)
                it.putExtra("Year", age)
                it.putExtra("Cou", cou)

                startActivity(it)
            }
        }
    }
}
