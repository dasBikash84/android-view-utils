package com.dasbikash.android_view_utils.custom_views.long_click_menu

import androidx.annotation.Keep

@Keep
data class LongClickMenuItem(
    val text:String,
    val task:()->Unit
)