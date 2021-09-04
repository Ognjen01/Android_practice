package com.ognjenlazic.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_slidable_menu.*

class SlidableMenu : AppCompatActivity() {

    lateinit var  toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slidable_menu)

        toggle = ActionBarDrawerToggle(this, drawerlayout, R.string.open, R.string.close)
        drawerlayout.addDrawerListener(toggle)

        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.settings -> Toast.makeText(this, "You clicked settings", Toast.LENGTH_SHORT).show()
            R.id.ddContact -> Toast.makeText(this, "You clicked contact", Toast.LENGTH_SHORT).show()
            R.id.feedback -> Toast.makeText(this, "You clicked settings", Toast.LENGTH_SHORT).show()
            R.id.close -> Toast.makeText(this, "You clicked close", Toast.LENGTH_SHORT).show()
            R.id.favorite -> Toast.makeText(this, "You clicked favorite", Toast.LENGTH_SHORT).show()


            }
            true
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
