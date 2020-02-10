package com.dasbikash.android_view_utils.utils

import android.view.View
import android.view.ViewGroup

interface WaitScreenOwner {
    fun registerWaitScreen(): ViewGroup
    fun hideWaitScreen() {
        registerWaitScreen().visibility = View.GONE
    }

    fun showWaitScreen() {
        registerWaitScreen().setOnClickListener {  }
        registerWaitScreen().visibility = View.VISIBLE
        registerWaitScreen().bringToFront()
    }
}