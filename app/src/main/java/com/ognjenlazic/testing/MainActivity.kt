package com.ognjenlazic.testing

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.costomtoast.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var reciver : AirplaneModeChangeReciver

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // broadcast recivers

        reciver = AirplaneModeChangeReciver()


        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(AirplaneModeChangeReciver(), it)
        }



        val job = GlobalScope.launch(Dispatchers.Default) {
            repeat(5){
                Log.d(TAG, "Corountine is still working")
                kotlinx.coroutines.delay(1000L)
            }


        }

        runBlocking {
            job.join()
            Log.d(TAG, "Main thread is continouing...")
        }





        GlobalScope.launch(Dispatchers.IO) {
            Log.d(TAG, "STarting coroutntine in thread ${Thread.currentThread().name}")
            val answer = doNetworkCall()
            withContext(Dispatchers.Main) //Mijenjanje threda od stran ecorountina {

            {
                Toast.makeText(this@MainActivity, answer, Toast.LENGTH_LONG).show()
                Log.d(TAG, "SSetting coroutntine in thread ${Thread.currentThread().name}")
            }

        }



        showToast.setOnClickListener {
            Toast(this).apply {
                duration = Toast.LENGTH_LONG
                view = layoutInflater.inflate(R.layout.costomtoast, clToast)
                show()
            }
        }

        toACtivity.setOnClickListener {
            Intent(this, secondActivity :: class.java).also {
                startActivity(it)
            }
        }

        toPassing.setOnClickListener {
            Intent(this, Passing1 :: class.java).also {
                startActivity(it)

            }
        }

        implicitIntents.setOnClickListener {
            Intent(this, ImplicitIntents :: class.java).also {
                startActivity(it)
            }
        }

        toolbarMenu.setOnClickListener {
            Intent(this, ToolbarMenu :: class.java).also {
                startActivity(it)
            }
        }

        alertDialog.setOnClickListener {
            Intent(this, AlertDialog :: class.java).also {
                startActivity(it)
            }
        }

        spinner.setOnClickListener {
            Intent(this, Spinner :: class.java).also {
                startActivity(it)
            }
        }

        recyclerView.setOnClickListener {
            Intent(this, recyclarView :: class.java).also {
                startActivity(it)
            }
        }

        fragments.setOnClickListener {
            Intent(this, Fragments::class.java).also {
                startActivity(it)
            }
        }

        btnNavView.setOnClickListener {
            Intent(this, ButtonNavigationView :: class.java).also {
                startActivity(it)
            }
        }

        toPager.setOnClickListener {
            Intent(this, ViewPager2a :: class.java).also {
                startActivity(it)
            }
        }

        slidableM.setOnClickListener {
            Intent(this, SlidableMenu :: class.java).also {
                startActivity(it)
            }
        }

        savData.setOnClickListener {
            Intent(this, SavingData :: class.java).also {
                startActivity(it)
            }
        }

        toNot.setOnClickListener {
            Intent(this, Notification :: class.java).also {
                startActivity(it)
            }
        }

        toIntServ.setOnClickListener {
            Intent(this, IntentServ :: class.java).also {
                startActivity(it)
            }
        }

        DandD.setOnClickListener {
            Intent(this, DragAndDrop :: class.java).also {
                startActivity(it)
            }
        }

        GlideGo.setOnClickListener {
            Intent(this, GlideOn ::class.java).also {
                startActivity(it)
            }
        }



    }
    suspend fun doNetworkCall(): String{
        kotlinx.coroutines.delay(3000L)
        return "This is the answer"
    }

/*
    override fun onStop() {
        super.onStop()
        unregisterReceiver(reciver)
    }

 */
}
