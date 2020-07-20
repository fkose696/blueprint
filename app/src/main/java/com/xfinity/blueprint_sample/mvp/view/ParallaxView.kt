package com.xfinity.blueprint_sample.mvp.view

import android.view.View
import android.widget.TextView
import com.xfinity.blueprint_annotations.ComponentViewClass
import com.xfinity.blueprint_annotations.ComponentViewHolder
import com.xfinity.blueprint_sample.R

@ComponentViewClass(viewHolderClass = ParallaxViewHolder::class)
class ParallaxView : ParallaxViewBase()

@ComponentViewHolder(viewType = R.layout.data_item_view)
class ParallaxViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
    val data: TextView = itemView.findViewById(R.id.data) as TextView
}