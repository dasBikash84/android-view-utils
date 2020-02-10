package com.dasbikash.android_view_utils.custom_views

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.LinearLayoutCompat

class ClickableLinearLayout: LinearLayoutCompat {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(ClickUtils.getClickListnerWithDimming(l))
    }
}