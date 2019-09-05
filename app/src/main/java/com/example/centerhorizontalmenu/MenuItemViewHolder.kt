package com.example.centerhorizontalmenu

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
/**
 * Created by Rayaane Abdessmad on 04/09/19.
 */
class MenuItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

    val tvItem: TextView? = itemView?.findViewById(R.id.tv_item)
    val img : ImageView? = itemView?.findViewById(R.id.img_item_menu)
    val img_selected : ImageView? = itemView?.findViewById(R.id.selected_img)
}