package com.dasbikash.android_view_utils.utils

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.dasbikash.android_view_utils.R
import com.dasbikash.android_view_utils.utils.SnackBarUtils.Companion.DEFAULT_ACTION_TEXT_CASE_IS_UPPER
import com.dasbikash.android_view_utils.utils.SnackBarUtils.Companion.DEFAULT_ACTION_TEXT_COLOR
import com.google.android.material.snackbar.Snackbar

/**
 * Helper class to display Snackbar.
 *
 * */
class SnackBarUtils {

    companion object {

        internal val DEFAULT_ACTION_TEXT_COLOR = Color.MAGENTA
        internal val DEFAULT_ACTION_TEXT_CASE_IS_UPPER = false

        @JvmStatic
        fun showShortSnack(
            view: View, message: String,
            actionText: CharSequence? = null, action: () -> Unit = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = showSnack(
            view, message, Snackbar.LENGTH_SHORT,
            actionText, action, actionTextColor, actionTextUpperCase
        )

        @JvmStatic
        fun showShortSnack(
            view: View, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: () -> Unit = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) {
            view.context.applicationContext.apply {
                showSnack(
                    view, getString(messageId), Snackbar.LENGTH_SHORT,
                    actionText, action, actionTextColor, actionTextUpperCase
                )
            }
        }

        @JvmStatic
        fun showLongSnack(
            view: View, message: String,
            actionText: CharSequence? = null, action: () -> Unit = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = showSnack(
            view, message, Snackbar.LENGTH_LONG,
            actionText, action, actionTextColor, actionTextUpperCase
        )

        @JvmStatic
        fun showLongSnack(
            view: View, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: () -> Unit = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) {
            view.context.applicationContext.apply {
                showSnack(
                    view, getString(messageId), Snackbar.LENGTH_LONG,
                    actionText, action, actionTextColor, actionTextUpperCase
                )
            }
        }

        @JvmStatic
        fun showShortSnack(
            activity: Activity, message: String,
            actionText: CharSequence? = null, action: () -> Unit = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = activity.showShortSnack(
            message,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        @JvmStatic
        fun showShortSnack(
            activity: Activity, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: () -> Unit = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = activity.showShortSnack(
            messageId,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        @JvmStatic
        fun showLongSnack(
            activity: Activity, message: String,
            actionText: CharSequence? = null, action: () -> Unit = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = activity.showLongSnack(
            message,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        @JvmStatic
        fun showLongSnack(
            activity: Activity, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: () -> Unit = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = activity.showLongSnack(
            messageId,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        @JvmStatic
        fun showShortSnack(
            activity: AppCompatActivity, message: String,
            actionText: CharSequence? = null, action: () -> Unit = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = activity.showShortSnack(
            message,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        @JvmStatic
        fun showShortSnack(
            activity: AppCompatActivity, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: () -> Unit = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = activity.showShortSnack(
            messageId,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        @JvmStatic
        fun showLongSnack(
            activity: AppCompatActivity, message: String,
            actionText: CharSequence? = null, action: () -> Unit = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = activity.showLongSnack(
            message,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        @JvmStatic
        fun showLongSnack(
            activity: AppCompatActivity, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: () -> Unit = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = activity.showLongSnack(
            messageId,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        @JvmStatic
        fun showShortSnack(
            fragment: Fragment, message: String,
            actionText: CharSequence? = null, action: () -> Unit = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = fragment.showShortSnack(
            message,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        @JvmStatic
        fun showShortSnack(
            fragment: Fragment, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: () -> Unit = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = fragment.showShortSnack(
            messageId,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        @JvmStatic
        fun showLongSnack(
            fragment: Fragment, message: String,
            actionText: CharSequence? = null, action: () -> Unit = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = fragment.showLongSnack(
            message,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        @JvmStatic
        fun showLongSnack(
            fragment: Fragment, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: () -> Unit = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = fragment.showLongSnack(
            messageId,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        private fun showSnack(
            view: View, message: String,
            duration: Int, actionText: CharSequence?, action: () -> Unit,
            @ColorInt actionTextColor: Int, actionTextUpperCase: Boolean
        ) {
            try {
                val snackbar = Snackbar.make(view, message, duration)
                actionText?.let {
                    setSnackbarAction(snackbar, it, action, actionTextColor, actionTextUpperCase)
                }
                runOnMainThread(task = {
                    snackbar.show()
                })
            } catch (ex: IllegalArgumentException) {
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

fun Activity.runWithView(task:(View)->Any?){
    if (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            !isDestroyed
        } else {
            true
        }
    ) {
        findViewById<View>(android.R.id.content).let {
            task(it)
        }
    }
}

fun AppCompatActivity.runWithView(task:(View)->Any?){
    if (lifecycle.currentState==Lifecycle.State.RESUMED) {
        findViewById<View>(android.R.id.content).let {
            task(it)
        }
    }
}

fun Fragment.runWithView(task:(View)->Any?){
    if (lifecycle.currentState==Lifecycle.State.RESUMED) {
        view?.let {
            task(it)
        }
    }
}

fun Activity.showShortSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: () -> Unit = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = showShortSnack(getString(messageId),actionText, action, actionTextColor, actionTextUpperCase)

fun Activity.showShortSnack(
    message:String,
    actionText: CharSequence? = null,
    action: () -> Unit = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) {
    runWithView {
            SnackBarUtils.showShortSnack(
                it,
                message,
                actionText,
                action,
                actionTextColor,
                actionTextUpperCase
            )
        }
}

fun Activity.showLongSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: () -> Unit = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = showLongSnack(getString(messageId),actionText, action, actionTextColor, actionTextUpperCase)

fun Activity.showLongSnack(
    message:String,
    actionText: CharSequence? = null,
    action: () -> Unit = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) {
    runWithView {
            it.showLongSnack(
                message,
                actionText,
                action,
                actionTextColor,
                actionTextUpperCase
            )
        }
}

fun AppCompatActivity.showShortSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: () -> Unit = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = showShortSnack(getString(messageId),actionText, action, actionTextColor, actionTextUpperCase)

fun AppCompatActivity.showShortSnack(
    message:String,
    actionText: CharSequence? = null,
    action: () -> Unit = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) {
    runWithView {
            it.showShortSnack(
                message,
                actionText,
                action,
                actionTextColor,
                actionTextUpperCase
            )
        }
}

fun AppCompatActivity.showLongSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: () -> Unit = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = showLongSnack(getString(messageId),actionText, action, actionTextColor, actionTextUpperCase)

fun AppCompatActivity.showLongSnack(
    message:String,
    actionText: CharSequence? = null,
    action: () -> Unit = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) {
    runWithView {
            it.showLongSnack(
                message,
                actionText,
                action,
                actionTextColor,
                actionTextUpperCase
            )
        }
}

fun Fragment.showShortSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: () -> Unit = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = showShortSnack(getString(messageId),actionText, action, actionTextColor, actionTextUpperCase)

fun Fragment.showShortSnack(
    message:String,
    actionText: CharSequence? = null,
    action: () -> Unit = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) {
    runWithView {
            it.showShortSnack(
                message,
                actionText,
                action,
                actionTextColor,
                actionTextUpperCase
            )
        }
}

fun Fragment.showLongSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: () -> Unit = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = showLongSnack(getString(messageId),actionText, action, actionTextColor, actionTextUpperCase)

fun Fragment.showLongSnack(
    message:String,
    actionText: CharSequence? = null,
    action: () -> Unit = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) {
    runWithView {
            it.showLongSnack(
                message,
                actionText,
                action,
                actionTextColor,
                actionTextUpperCase
            )
        }
}