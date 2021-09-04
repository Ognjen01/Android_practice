package com.ognjenlazic.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_button_navigation_view.*

class ButtonNavigationView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_navigation_view)

        val firstFragment = FirstF()
        val secondFragment = SecondF()
        val thirdFragment = ThirdF()

        setCurrentFragment(firstFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miHome -> setCurrentFragment(firstFragment)
                R.id.miMessage -> setCurrentFragment(secondFragment)
                R.id.miProfile -> setCurrentFragment(thirdFragment)
            }
            true

        }

        bottomNavigationView.getOrCreateBadge(R.id.miMessage).apply {
            number = 10
            isVisible = true
        }
    }

    private fun setCurrentFragment(fragment : Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment1, fragment)
            commit()
        }

}

