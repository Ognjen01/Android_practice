package com.ognjenlazic.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_view_pager2.*

class ViewPager2a : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2)

        val images = listOf(
            R.drawable.ognjenlazic,
            R.drawable.ognjenlazic,
            R.drawable.ognjenlazic,
            R.drawable.ognjenlazic,
            R.drawable.ognjenlazic,
            R.drawable.ognjenlazic
        )

        val adapter = ViewPagerAdapter(images)
        viewPager.adapter = adapter

        /*
        Za VERTIKALNO SKROLOVANJE NA OVAJ NACIN SE MIJENJA

        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL

         */


        TabLayoutMediator(tabLayout, viewPager){

            tab, position ->
            tab.text = "Tab ${position +1}"

        }.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewPager2a, "Reselected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewPager2a, "Unselected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

                Toast.makeText(this@ViewPager2a, "Selected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }
        })


    }
}
