package com.dasbikash.android_view_utils.utils

import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.dasbikash.android_view_utils.R
import com.google.android.material.snackbar.Snackbar

object SnackBarUtils {

    fun showShortSnack(coordinatorLayout: CoordinatorLayout, message: String,
                       text:CharSequence?=null, listner:()->Unit= {  }) {
        val snackbar = Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_SHORT)
        text?.let {
            setSnackbarAction(snackbar, it, listner)
        }
        runOnMainThread (task = {
            snackbar.show()
        })
    }

    fun showLongSnack(coordinatorLayout: CoordinatorLayout, message: String,
                      text:CharSequence?=null, listner:()->Unit= {  }) {
        val snackbar = Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG)
        text?.let {
            setSnackbarAction(snackbar, it, listner)
        }
        runOnMainThread (task =  {
            snackbar.show()
        })
    }

    private fun setSnackbarAction(
        snackbar: Snackbar,
        it: CharSequence,
        listner: () -> Unit
    ) {
        snackbar
            .setAction(it, View.OnClickListener { listner() })
            .setActionTextColor(Color.WHITE)
            .getView()
            .findViewById<TextView>(R.id.snackbar_action)
            .setAllCaps(false)
    }
}

internal fun runOnMainThread(task: () -> Any?,delayMs:Long=0L){
    Handler(Looper.getMainLooper()).postDelayed( { task() },delayMs)
}