package com.dasbikash.android_view_utils.custom_views.long_click_menu

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.dasbikash.android_view_utils.R

internal class LongClickMenuItemHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    private val mMenuItemText:AppCompatTextView
    private val mSeparator:View
    init {
        mMenuItemText = itemView.findViewById(R.id.menu_item_text)
        mSeparator = itemView.findViewById(R.id.seperator)
    }
    fun bind(longClickMenuItem: LongClickMenuItem?, position: Int, itemCount: Int) {
        longClickMenuItem?.apply {
            mMenuItemText.text = text
            if (position == (itemCount-1)){
                mSeparator.visibility = View.GONE
            }
        }
    }
}