package com.dasbikash.android_view_utils.custom_views

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

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