package com.teslacode.viper.listeners

import android.view.View

/**
 * Created by adefruandta on 8/5/17.
 */

interface OnItemClickListener<in T> {

    fun onClick(v: View, position: Int, data: T?)
}
