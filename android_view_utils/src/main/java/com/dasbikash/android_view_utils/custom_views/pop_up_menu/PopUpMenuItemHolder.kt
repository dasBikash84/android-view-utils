package com.dasbikash.android_view_utils.custom_views.pop_up_menu

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.dasbikash.android_view_utils.R

internal class PopUpMenuItemHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    val mMenuItemText:AppCompatTextView = itemView.findViewById(R.id.menu_item_text)
    private val mSeparator:View = itemView.findViewById(R.id.seperator)

    fun bind(popUpMenuItem: PopUpMenuItem?, position: Int, itemCount: Int) {
        popUpMenuItem?.apply {
            mMenuItemText.text = text
            if (position == (itemCount-1)){
                mSeparator.visibility = View.GONE
            }
        }
    }
}