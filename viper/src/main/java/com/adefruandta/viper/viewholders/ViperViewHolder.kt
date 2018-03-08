package com.adefruandta.viper.viewholders

import android.content.Context
import android.view.View
import com.adefruandta.viper.listeners.OnItemClickListener

/**
 * Created by adefruandta on 8/4/17.
 */

open class ViperViewHolder<T>(var itemView: View) {

    // region Attributes

    open var position: Int = -1

    open val context: Context
        get() = this.itemView.context

    open var onItemClickListener: OnItemClickListener<T>? = null

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

    open fun setOnItemClickListener(listener: (View, Int, T?) -> Unit) {
        this.onItemClickListener = object : OnItemClickListener<T> {
            override fun onClick(v: View, position: Int, data: T?) {
                listener(v, position, data)
            }
        }
    }

    // endregion
}