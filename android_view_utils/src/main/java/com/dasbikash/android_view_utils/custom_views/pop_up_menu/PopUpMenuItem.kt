package com.dasbikash.android_view_utils.custom_views.pop_up_menu

import androidx.annotation.Keep

@Keep
data class PopUpMenuItem(
    val text:String,
    val task:()->Unit
)