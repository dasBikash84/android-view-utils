package com.dasbikash.android_view_utils.custom_views.long_click_menu

import androidx.recyclerview.widget.DiffUtil
import com.dasbikash.android_view_utils.custom_views.long_click_menu.LongClickMenuItem

internal object LongClickMenuItemDiffCallback:DiffUtil.ItemCallback<LongClickMenuItem>() {
    override fun areItemsTheSame(oldItem: LongClickMenuItem, newItem: LongClickMenuItem)= oldItem == newItem
    override fun areContentsTheSame(oldItem: LongClickMenuItem, newItem: LongClickMenuItem)= false
}