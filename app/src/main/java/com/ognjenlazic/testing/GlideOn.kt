package com.ognjenlazic.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_glide_on.*

class GlideOn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide_on)

        val imageURL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbk0YDyfWSiZJNMehf3KvJrbLPvVyUTyM2nt0TGwCGjJB06-WDNg"
        val incorrectImageURL = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fblog.mindorks.com%2Fdownloading-and-showing-image-with-glide-library-in-android&psig=AOvVaw1jIDOCS2O_SS0xIPKK1fPI&ust=1587651229535000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCPi6te6b_OgCFQAAAAAdAAAAABAD"

        Glide.with(this)
            .load(imageURL)
            .placeholder(R.drawable.ognjenlazic)
            .into(ivImage00)
            

    }
}
