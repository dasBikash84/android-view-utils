package com.dasbikash.android_view_utils.custom_views.pop_up_menu


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ListAdapter
import com.dasbikash.android_view_utils.R

internal class PopUpMenuItemAdapter(val alertDialog: AlertDialog):ListAdapter<PopUpMenuItem, PopUpMenuItemHolder>(
    PopUpMenuItemDiffCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopUpMenuItemHolder {
        return PopUpMenuItemHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_pop_up_menu_item, parent, false
            )
        )
    }
    override fun onBindViewHolder(holder: PopUpMenuItemHolder, position: Int) {
        val menuItem = getItem(position)
        holder.itemView.setOnClickListener {
            alertDialog.hide()
            menuItem.task()
        }
        holder.bind(getItem(position),position,itemCount)
    }
}