package com.ognjenlazic.testing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent_serv.*

class IntentServ : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_serv)

        itStart.setOnClickListener {
            /* Intent(this, MyIntentService :: class.java).also {
                startService(it)
                itText.text = "Service running"

             */

            Intent(this, MyService ::class.java).also {
                startService(it)
                itText.text = "Service running"
            }
            }

        itStop.setOnClickListener {
            Intent(this, MyService :: class.java).also {
                stopService(it)
                itText.text ="Service stopped"
            }
        }

        btnSendData.setOnClickListener {
            Intent(this, MyService ::class.java).also {
                val dataString = etData.text.toString()
                it.putExtra("EXTRA_DATA", dataString)
                startService(it)
                }
            }
        }


        }





