package com.teslacode.viper.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.teslacode.viper.listeners.OnItemClickListener

/**
 * Created by adefruandta on 8/13/17.
 */

abstract class BaseRecyclerViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    // region Attributes

    var onItemClickListener: OnItemClickListener<T>? = null

    // endregion

    // region Base View Holder

    open fun onBind(data: T) {
        this.itemView.setOnClickListener { onItemClick(it, adapterPosition, data) }
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
