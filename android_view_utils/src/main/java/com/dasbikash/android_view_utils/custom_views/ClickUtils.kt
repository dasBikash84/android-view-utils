package com.dasbikash.android_view_utils.custom_views

import android.animation.ObjectAnimator
import android.view.View

internal object ClickUtils {
    private const val DIMMING_DURATION = 100L

    fun getClickListnerWithDimming(l: View.OnClickListener?): View.OnClickListener {
        return object : View.OnClickListener {
            override fun onClick(v: View?) {
                val animation = ObjectAnimator.ofFloat(v, "alpha", 0.0f, 1.0f)
                animation.duration = DIMMING_DURATION
                animation.start()
                l?.onClick(v)
            }
        }
    }
}