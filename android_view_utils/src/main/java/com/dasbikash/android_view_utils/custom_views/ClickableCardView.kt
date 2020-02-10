package com.dasbikash.android_view_utils.custom_views

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.card.MaterialCardView

class ClickableCardView:MaterialCardView{
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