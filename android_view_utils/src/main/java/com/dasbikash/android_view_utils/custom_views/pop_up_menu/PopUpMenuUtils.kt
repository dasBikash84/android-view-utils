package com.dasbikash.android_view_utils.custom_views.pop_up_menu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dasbikash.android_view_utils.R
import com.dasbikash.android_view_utils.utils.DialogUtils

object PopUpMenuUtils {

    fun launchPopUpMenu(context: Context, popUpMenuItems: Collection<PopUpMenuItem>, doOnMenuLaunch:(()->Unit)={})
            :Boolean{
        if (popUpMenuItems.isEmpty()){return true}
        val popUpMenu =
            LayoutInflater.from(context).inflate(R.layout.view_pop_up_menu_holder,null,false) as RecyclerView
        val dialog = DialogUtils.createAlertDialog(context, DialogUtils.AlertDialogDetails(
            positiveButtonText = "",negetiveButtonText = "",
            view = popUpMenu
        ))
        val menuAdapter =
            PopUpMenuItemAdapter(
                dialog
            )
        popUpMenu.adapter = menuAdapter
        menuAdapter.submitList(popUpMenuItems.toList())
        dialog.show()
        doOnMenuLaunch.let {
            it()
        }
        return true
    }


    fun attachPopUpMenuForLongClick(view: View,popUpMenuItems: Collection<PopUpMenuItem>, doOnMenuLaunch:(()->Unit)={}){
        view.setOnLongClickListener {
            launchPopUpMenu(
                it.context,
                popUpMenuItems,
                doOnMenuLaunch
            )
        }
    }

    fun attachPopUpMenuForClick(view: View,popUpMenuItems: Collection<PopUpMenuItem>, doOnMenuLaunch:(()->Unit)={}){
        view.setOnClickListener {
            launchPopUpMenu(
                it.context,
                popUpMenuItems,
                doOnMenuLaunch
            )
        }
    }
}

fun View.attachPopUpMenuForLongClick(popUpMenuItems: Collection<PopUpMenuItem>, doOnMenuLaunch:(()->Unit)={}){
    setOnLongClickListener {
        PopUpMenuUtils.launchPopUpMenu(
            it.context,
            popUpMenuItems,
            doOnMenuLaunch
        )
    }
}
fun View.attachPopUpMenuForClick(popUpMenuItems: Collection<PopUpMenuItem>, doOnMenuLaunch:(()->Unit)={}){
    setOnClickListener {
        PopUpMenuUtils.launchPopUpMenu(
            it.context,
            popUpMenuItems,
            doOnMenuLaunch
        )
    }
}