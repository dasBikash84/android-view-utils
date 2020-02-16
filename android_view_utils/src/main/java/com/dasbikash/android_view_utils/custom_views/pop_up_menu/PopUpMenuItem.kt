package com.dasbikash.android_view_utils.custom_views.pop_up_menu

import androidx.annotation.Keep
/**
 * Model class an instance of which will be assigned to each
 * menu entry of <b>pop up menu</b> custom view
 *
 * @author Bikash das(das.bikash.dev@gmail.com)
 * @property text Menu entry title that will shown on menu.
 * @property task Function that will be executed on menu item click.
 * */
@Keep
class PopUpMenuItem(
    val text:String,
    val task:()->Any?
)