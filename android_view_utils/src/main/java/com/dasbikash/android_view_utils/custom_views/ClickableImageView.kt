package com.dasbikash.android_view_utils.custom_views

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

/**
 * Custom view class wrapping <b>ImageView</b>.
 * If click listener attached then this view will display
 * a blink animation on click.
 *
 * @author Bikash Das(das.bikash.dev@gmail.com)
 * */
class ClickableImageView:ImageView{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(ClickUtils.getClickListnerWithDimming(l))
    }
}