package com.dasbikash.android_view_utils.custom_views.pop_up_menu

import androidx.recyclerview.widget.DiffUtil

internal object PopUpMenuItemDiffCallback:DiffUtil.ItemCallback<PopUpMenuItem>() {
    override fun areItemsTheSame(oldItem: PopUpMenuItem, newItem: PopUpMenuItem)= oldItem == newItem
    override fun areContentsTheSame(oldItem: PopUpMenuItem, newItem: PopUpMenuItem)= false
}