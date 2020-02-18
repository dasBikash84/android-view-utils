package com.dasbikash.android_view_utils.utils

import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.StringRes
import androidx.coordinatorlayout.widget.CoordinatorLayout
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
        coordinatorLayout: CoordinatorLayout, message: String,
        actionText: CharSequence? = null, action: () -> Unit = { },
        @ColorInt actionTextColor:Int=DEFAULT_ACTION_TEXT_COLOR,
        actionTextUpperCase:Boolean=DEFAULT_ACTION_TEXT_CASE_IS_UPPER
    ) = showSnack(coordinatorLayout,message,Snackbar.LENGTH_SHORT,
                    actionText, action, actionTextColor, actionTextUpperCase)

    fun showShortSnack(
        coordinatorLayout: CoordinatorLayout, @StringRes messageId: Int,
        actionText: CharSequence? = null, action: () -> Unit = { },
        @ColorInt actionTextColor:Int=DEFAULT_ACTION_TEXT_COLOR,
        actionTextUpperCase:Boolean=DEFAULT_ACTION_TEXT_CASE_IS_UPPER
    ) {
        coordinatorLayout.context.applicationContext.apply {
            showSnack(coordinatorLayout, getString(messageId),Snackbar.LENGTH_SHORT,
                            actionText, action,actionTextColor, actionTextUpperCase)
        }
    }

    fun showLongSnack(
        coordinatorLayout: CoordinatorLayout, message: String,
        actionText: CharSequence? = null, action: () -> Unit = { },
        @ColorInt actionTextColor:Int=DEFAULT_ACTION_TEXT_COLOR,
        actionTextUpperCase:Boolean=DEFAULT_ACTION_TEXT_CASE_IS_UPPER
    ) = showSnack(coordinatorLayout,message,Snackbar.LENGTH_LONG,
        actionText, action, actionTextColor, actionTextUpperCase)

    fun showLongSnack(
        coordinatorLayout: CoordinatorLayout, @StringRes messageId: Int,
        actionText: CharSequence? = null, action: () -> Unit = { },
        @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
        actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
    ) {
        coordinatorLayout.context.applicationContext.apply {
            showSnack(coordinatorLayout, getString(messageId),Snackbar.LENGTH_LONG,
                            actionText, action,actionTextColor, actionTextUpperCase)
        }
    }

    private fun showSnack(
        coordinatorLayout: CoordinatorLayout, message: String,
        duration:Int,actionText: CharSequence?, action: () -> Unit,
        @ColorInt actionTextColor: Int,actionTextUpperCase: Boolean
    ){
        val snackbar = Snackbar.make(coordinatorLayout, message, duration)
        actionText?.let {
            setSnackbarAction(snackbar, it, action,actionTextColor, actionTextUpperCase)
        }
        runOnMainThread(task = {
            snackbar.show()
        })
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

fun CoordinatorLayout.showShortSnack(
    message: String,
    actionText: CharSequence? = null,
    action: () -> Unit = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = SnackBarUtils.showShortSnack(this, message, actionText, action,actionTextColor,actionTextUpperCase)

fun CoordinatorLayout.showShortSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: () -> Unit = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = SnackBarUtils.showShortSnack(this, messageId, actionText, action,actionTextColor,actionTextUpperCase)

fun CoordinatorLayout.showLongSnack(
    message: String,
    actionText: CharSequence? = null,
    action: () -> Unit = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = SnackBarUtils.showLongSnack(this, message, actionText, action,actionTextColor,actionTextUpperCase)

fun CoordinatorLayout.showLongSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: () -> Unit = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = SnackBarUtils.showLongSnack(this, messageId, actionText, action,actionTextColor,actionTextUpperCase)

