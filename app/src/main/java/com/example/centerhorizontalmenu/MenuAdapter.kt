package com.example.centerhorizontalmenu

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by nbtk on 5/4/18.
 */
class MenuAdapter (var data : ArrayList<MenuItemModel>, var callback: MenuItemSelected? ) : RecyclerView.Adapter<MenuItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false)

        val horizontalViewHolder = MenuItemViewHolder(itemView)
        return horizontalViewHolder
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        holder.tvItem?.text = data[position].name
        holder.img?.setImageResource(data[position].itemImage)
        holder.img_selected?.setImageResource(data[position].selectedImage)
        if(data[position].isSelected == true) {
            holder.img_selected!!.visibility = View.VISIBLE
            holder.img!!.visibility = View.GONE
        }
        else {
            holder.img_selected!!.visibility = View.GONE
            holder.img!!.visibility = View.VISIBLE
        }

        holder.itemView.setOnClickListener {
            callback!!.menuItemSelected(it)


            for( b in 0 .. data.size-1) {
                data[b].isSelected = false
            }
            data[position].isSelected = true

            if(data[position].isSelected == true) {
                holder.img_selected.visibility = View.VISIBLE
                holder.img.visibility = View.GONE
            }
            else {
                holder.img_selected.visibility = View.GONE
                holder.img.visibility = View.VISIBLE
            }
        }




    }





}