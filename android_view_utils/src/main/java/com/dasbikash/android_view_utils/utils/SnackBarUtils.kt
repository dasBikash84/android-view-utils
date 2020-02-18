package com.dasbikash.android_view_utils.utils

import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.StringRes
import com.dasbikash.android_view_utils.R
import com.dasbikash.android_view_utils.utils.SnackBarUtils.DEFAULT_ACTION_TEXT_CASE_IS_UPPER
import com.dasbikash.android_view_utils.utils.SnackBarUtils.DEFAULT_ACTION_TEXT_COLOR
import com.google.android.material.snackbar.Snackbar

/**
 * Helper class to display Snackbar.
 *
 * */
object SnackBarUtils {

    internal val DEFAULT_ACTION_TEXT_COLOR = Color.MAGENTA
    internal val DEFAULT_ACTION_TEXT_CASE_IS_UPPER = false

    fun showShortSnack(
        view: View, message: String,
        actionText: CharSequence? = null, action: () -> Unit = { },
        @ColorInt actionTextColor:Int=DEFAULT_ACTION_TEXT_COLOR,
        actionTextUpperCase:Boolean=DEFAULT_ACTION_TEXT_CASE_IS_UPPER
    ) = showSnack(view,message,Snackbar.LENGTH_SHORT,
                    actionText, action, actionTextColor, actionTextUpperCase)

    fun showShortSnack(
        view: View, @StringRes messageId: Int,
        actionText: CharSequence? = null, action: () -> Unit = { },
        @ColorInt actionTextColor:Int=DEFAULT_ACTION_TEXT_COLOR,
        actionTextUpperCase:Boolean=DEFAULT_ACTION_TEXT_CASE_IS_UPPER
    ) {
        view.context.applicationContext.apply {
            showSnack(view, getString(messageId),Snackbar.LENGTH_SHORT,
                            actionText, action,actionTextColor, actionTextUpperCase)
        }
    }

    fun showLongSnack(
        view: View, message: String,
        actionText: CharSequence? = null, action: () -> Unit = { },
        @ColorInt actionTextColor:Int=DEFAULT_ACTION_TEXT_COLOR,
        actionTextUpperCase:Boolean=DEFAULT_ACTION_TEXT_CASE_IS_UPPER
    ) = showSnack(view,message,Snackbar.LENGTH_LONG,
        actionText, action, actionTextColor, actionTextUpperCase)

    fun showLongSnack(
        view: View, @StringRes messageId: Int,
        actionText: CharSequence? = null, action: () -> Unit = { },
        @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
        actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
    ) {
        view.context.applicationContext.apply {
            showSnack(view, getString(messageId),Snackbar.LENGTH_LONG,
                            actionText, action,actionTextColor, actionTextUpperCase)
        }
    }

    private fun showSnack(
        view: View, message: String,
        duration:Int,actionText: CharSequence?, action: () -> Unit,
        @ColorInt actionTextColor: Int,actionTextUpperCase: Boolean
    ){
        try {
            val snackbar = Snackbar.make(view, message, duration)
            actionText?.let {
                setSnackbarAction(snackbar, it, action, actionTextColor, actionTextUpperCase)
            }
            runOnMainThread(task = {
                snackbar.show()
            })
        }catch (ex:IllegalArgumentException){
            runOnMainThread(task = {
                Toast.makeText(
                    view.context, message, when {
                        duration == Snackbar.LENGTH_LONG -> Toast.LENGTH_LONG
                        else -> Toast.LENGTH_SHORT
                    }
                ).show()
            })
        }
    }

    private fun setSnackbarAction(
        snackbar: Snackbar,
        actionText: CharSequence,
        action: () -> Unit,
        @ColorInt actionTextColor: Int,
        actionTextUpperCase: Boolean
    ) {
        snackbar
            .setAction(actionText) { runOnMainThread({ action() }) }
            .setActionTextColor(actionTextColor)
            .getView()
            .findViewById<TextView>(R.id.snackbar_action)
            .setAllCaps(actionTextUpperCase)
    }
}

internal fun runOnMainThread(task: () -> Any?, delayMs: Long = 0L) {
    Handler(Looper.getMainLooper()).postDelayed({ task() }, delayMs)
}

fun View.showShortSnack(
    message: String,
    actionText: CharSequence? = null,
    action: () -> Unit = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = SnackBarUtils.showShortSnack(this, message, actionText, action,actionTextColor,actionTextUpperCase)

fun View.showShortSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: () -> Unit = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = SnackBarUtils.showShortSnack(this, messageId, actionText, action,actionTextColor,actionTextUpperCase)

fun View.showLongSnack(
    message: String,
    actionText: CharSequence? = null,
    action: () -> Unit = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = SnackBarUtils.showLongSnack(this, message, actionText, action,actionTextColor,actionTextUpperCase)

fun View.showLongSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: () -> Unit = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = SnackBarUtils.showLongSnack(this, messageId, actionText, action,actionTextColor,actionTextUpperCase)

