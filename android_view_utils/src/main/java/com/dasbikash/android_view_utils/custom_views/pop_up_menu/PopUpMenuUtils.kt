package com.dasbikash.android_view_utils.custom_views.pop_up_menu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dasbikash.android_view_utils.R
import com.dasbikash.android_view_utils.utils.DialogUtils
import com.dasbikash.android_view_utils.utils.runOnMainThread

/**
 * Util class for creating and configuring <b>pop up menu</b>
 * Custom view class where a task is attached with each menu item.
 *
 * Subject <b>pop up menu</b> will have view and characteristics
 * similar to right click menu of Personal Computers.
 *
 * @author Bikash Das(das.bikash.dev@gmail.com)
 * */
object PopUpMenuUtils {

    /**
     * Method to create and launch <b>pop up menu</b>
     *
     * @param context | Android Context
     * @param popUpMenuItems | Collection of PopUpMenuItem
     * */
    fun launchPopUpMenu(context: Context, popUpMenuItems: Collection<PopUpMenuItem>){
        if (popUpMenuItems.isEmpty()){return }
        val popUpMenu =
            LayoutInflater.from(context).inflate(R.layout.view_pop_up_menu_holder,null,false) as RecyclerView
        val dialog = DialogUtils.createAlertDialog(context, DialogUtils.AlertDialogDetails(
            positiveButtonText = "",negetiveButtonText = "",
            view = popUpMenu
        ))
        val menuAdapter = PopUpMenuItemAdapter(dialog)
        popUpMenu.adapter = menuAdapter
        menuAdapter.submitList(popUpMenuItems.toList())
        dialog.show()
    }


    /**
     * Method to attach <b>pop up menu</b> with a view click.
     * Menu will be displayed on click of subject view.
     *
     * @param view | Subject view
     * @param popUpMenuItems | Collection of PopUpMenuItem
     * */
    fun attachPopUpMenuForLongClick(view: View,popUpMenuItems: Collection<PopUpMenuItem>){
        view.setOnLongClickListener {
            launchPopUpMenu(
                it.context,
                popUpMenuItems
            )
            return@setOnLongClickListener true
        }
    }

    /**
     * Method to attach <b>pop up menu</b> with a view long click.
     * Menu will be displayed on long click of subject view.
     *
     * @param view | Subject view
     * @param popUpMenuItems | Collection of PopUpMenuItem
     * */
    fun attachPopUpMenuForClick(view: View,popUpMenuItems: Collection<PopUpMenuItem>){
        view.setOnClickListener {
            launchPopUpMenu(
                it.context,
                popUpMenuItems
            )
        }
    }
}
/**
 * Extension function to attach <b>pop up menu</b> with a view click.
 * Menu will be displayed on click of subject view.
 *
 * @param popUpMenuItems | Collection of PopUpMenuItem
 * */
fun View.attachPopUpMenuForLongClick(popUpMenuItems: Collection<PopUpMenuItem>)
    = PopUpMenuUtils.attachPopUpMenuForLongClick(this,popUpMenuItems)

/**
 * Method to attach <b>pop up menu</b> with a view long click.
 * Menu will be displayed on long click of subject view.
 *
 * @param popUpMenuItems | Collection of PopUpMenuItem
 * */

fun View.attachPopUpMenuForClick(popUpMenuItems: Collection<PopUpMenuItem>)
    = PopUpMenuUtils.attachPopUpMenuForClick(this,popUpMenuItems)