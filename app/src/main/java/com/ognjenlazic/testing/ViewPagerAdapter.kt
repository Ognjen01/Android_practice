package com.ognjenlazic.testing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view_pager.view.*

class ViewPagerAdapter (
    val image : List<Int>
) : RecyclerView.Adapter<ViewPagerAdapter.viewPAgerViewHolder>() {

    inner class viewPAgerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewPAgerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return viewPAgerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return image.size
    }

    override fun onBindViewHolder(holder: viewPAgerViewHolder, position: Int) {
        val curImage = image[position]
        holder.itemView.ivImage.setImageResource(curImage)
    }
}