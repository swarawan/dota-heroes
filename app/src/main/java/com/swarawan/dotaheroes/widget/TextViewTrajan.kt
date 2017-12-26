package com.swarawan.dotaheroes.widget

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet

/**
 * Created by rioswarawan on 12/26/17.
 */
class TextViewTrajan(context: Context, attributeSet: AttributeSet) : AppCompatTextView(context, attributeSet) {

    init {
        val typeface = Typeface.createFromAsset(getContext().assets, "font/TrajanProRegular.ttf")
        setTypeface(typeface)
    }
}