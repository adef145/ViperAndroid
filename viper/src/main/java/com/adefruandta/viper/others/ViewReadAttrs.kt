package com.adefruandta.viper.others

import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View

/**
 * Created by adefruandta on 8/7/17.
 */

fun View.readAttrs(styleable: IntArray, attrs: AttributeSet?, listener: (TypedArray) -> Unit) {
    if (attrs == null) {
        return
    }

    val ta: TypedArray = context.obtainStyledAttributes(attrs, styleable)

    try {
        listener(ta)
    } finally {
        ta.recycle()
    }
}

fun View.readAttrs(styleable: IntArray, listener: (TypedArray) -> Unit) {
    val typedValue = TypedValue()

    val ta: TypedArray = context.obtainStyledAttributes(typedValue.data, styleable)

    try {
        listener(ta)
    } finally {
        ta.recycle()
    }
}