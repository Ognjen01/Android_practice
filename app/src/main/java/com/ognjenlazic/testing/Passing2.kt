package com.ognjenlazic.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_passing2.*

class Passing2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passing2)

        val name1 = intent.getStringExtra("Name")
        val secondName1 = intent.getStringExtra("Second")
        val age = intent.getStringExtra("Year")
        val country = intent.getStringExtra("Cou")

        val personString = "$name1 $secondName1 is $age , and he is from $country"

        tekst.text = personString

        Log.v("PRENESENA VRIJEDNOST", personString)
    }
}
