package com.ognjenlazic.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_spinner.*

class Spinner : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        /*

        MOGUĆE JE I OVAKO DEFINISANJE LISTE U SPINNERU ALI SE MOŽE I KORISTITI NIZ KOJI JE DEFINISAN U sting FOLDERU U RES

        val customList = listOf("First", "Second", "Third")
        val adapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, customList)
        spMonth.adapter = adapter


         */

        spMonth.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@Spinner, "You selected ${adapterView?.getItemAtPosition(position).toString()}", Toast.LENGTH_LONG).show()
            }
        }
    }
}
