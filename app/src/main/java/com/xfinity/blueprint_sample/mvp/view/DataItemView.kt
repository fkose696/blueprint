/*
 * Copyright 2017 Comcast Cable Communications Management, LLC
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xfinity.blueprint_sample.mvp.view

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.xfinity.blueprint_annotations.ComponentViewClass
import com.xfinity.blueprint_annotations.ComponentViewHolder
import com.xfinity.blueprint_sample.R

@ComponentViewClass(viewHolderClass = DataItemViewHolder::class)
class DataItemView : DataItemViewBase() {
    fun setBehavior(behavior: (position: Int) -> Unit) {
        viewHolder.itemView.setOnClickListener { behavior.invoke(viewHolder.adapterPosition) }
    }
}

@ComponentViewHolder(viewType = R.layout.data_item_view)
class DataItemViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
    val data : TextView = itemView.findViewById(R.id.data) as TextView
}
