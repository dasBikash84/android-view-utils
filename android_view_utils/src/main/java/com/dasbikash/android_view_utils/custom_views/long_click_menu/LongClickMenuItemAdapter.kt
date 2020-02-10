package com.dasbikash.android_view_utils.custom_views.long_click_menu


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ListAdapter
import com.dasbikash.android_view_utils.R

internal class LongClickMenuItemAdapter(val alertDialog: AlertDialog):ListAdapter<LongClickMenuItem, LongClickMenuItemHolder>(
    LongClickMenuItemDiffCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LongClickMenuItemHolder {
        return LongClickMenuItemHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_long_click_menu_item, parent, false
            )
        )
    }
    override fun onBindViewHolder(holder: LongClickMenuItemHolder, position: Int) {
        val menuItem = getItem(position)
        holder.itemView.setOnClickListener {
            alertDialog.hide()
            menuItem.task()
        }
        holder.bind(getItem(position),position,itemCount)
    }
}