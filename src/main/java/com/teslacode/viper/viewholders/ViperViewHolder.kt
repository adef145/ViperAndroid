package com.teslacode.viper.viewholders

import android.content.Context
import android.view.View
import com.teslacode.viper.listeners.OnItemClickListener

/**
 * Created by adefruandta on 8/4/17.
 */

open class ViperViewHolder<T>(var itemView: View) {

    // region Attributes

    var position: Int = -1

    val context: Context
        get() = this.itemView.context

    var onItemClickListener: OnItemClickListener<T>? = null

    // endregion

    // region Base View Holder

    open fun onBind(data: T?) {
        this.itemView.setOnClickListener { onItemClick(it, position, data) }
    }

    open fun onItemClick(view: View, position: Int, data: T?) {
        onItemClickListener?.onClick(view, position, data)
    }

    // endregion

    // region Methods

    fun setOnItemClickListener(listener: (View, Int, T?) -> Unit) {
        this.onItemClickListener = object : OnItemClickListener<T> {
            override fun onClick(v: View, position: Int, data: T?) {
                listener(v, position, data)
            }
        }
    }

    // endregion
}