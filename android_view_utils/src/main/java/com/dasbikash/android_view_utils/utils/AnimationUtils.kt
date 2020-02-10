package com.dasbikash.android_view_utils.utils

import android.animation.ObjectAnimator
import android.view.View

fun View.startAlphaAnimation(duration:Long,start:Float=0.0f,end:Float=1.0f) {
    val animation = ObjectAnimator.ofFloat(this, "alpha", start,end)
    animation.duration = duration
    animation.start()
}
fun View.startRevAlphaAnimation(duration:Long,start:Float=1.0f,end:Float=0.0f) {
    val animation = ObjectAnimator.ofFloat(this, "alpha", start,end)
    animation.duration = duration
    animation.start()
}