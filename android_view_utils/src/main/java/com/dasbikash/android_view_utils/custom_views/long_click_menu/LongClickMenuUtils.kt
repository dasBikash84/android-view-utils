package com.dasbikash.android_view_utils.custom_views.long_click_menu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dasbikash.android_view_utils.R
import com.dasbikash.android_view_utils.utils.DialogUtils

object LongClickMenuUtils {

    fun launchLongClickMenu(context: Context, longClickMenuItems: Collection<LongClickMenuItem>, doOnMenuLaunch:(()->Unit)={})
            :Boolean{
        if (longClickMenuItems.isEmpty()){return true}
        val longClickMenu =
            LayoutInflater.from(context).inflate(R.layout.view_long_click_menu_holder,null,false) as RecyclerView
        val dialog = DialogUtils.createAlertDialog(context, DialogUtils.AlertDialogDetails(
            positiveButtonText = "",negetiveButtonText = "",
            view = longClickMenu
        ))
        val menuAdapter =
            LongClickMenuItemAdapter(
                dialog
            )
        longClickMenu.adapter = menuAdapter
        menuAdapter.submitList(longClickMenuItems.toList())
        dialog.show()
        doOnMenuLaunch.let {
            it()
        }
        return true
    }
}

fun View.attachLongClickMenu(longClickMenuItems: Collection<LongClickMenuItem>, doOnMenuLaunch:(()->Unit)={}){
    setOnLongClickListener {
        LongClickMenuUtils.launchLongClickMenu(
            it.context,
            longClickMenuItems,
            doOnMenuLaunch
        )
    }
}