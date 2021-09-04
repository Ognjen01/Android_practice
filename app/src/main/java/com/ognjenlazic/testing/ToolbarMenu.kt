package com.ognjenlazic.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class ToolbarMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar_menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when (item.itemId)
        {
         R.id.ddContact -> Toast.makeText(this, "Add Contact", Toast.LENGTH_SHORT).show()
            R.id.favorite -> Toast.makeText(this, "Go to favorites", Toast.LENGTH_SHORT).show()
            R.id.settings -> Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
            R.id.close -> finish()
            R.id.feedback -> Toast.makeText(this, "Give us feedback", Toast.LENGTH_SHORT).show()

        }

        return true
    }
}
