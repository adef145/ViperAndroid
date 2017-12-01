package com.adefruandta.viper.adapters

import android.content.Context
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.adefruandta.viper.listeners.OnItemClickListener
import com.adefruandta.viper.viewholders.ViperViewHolder

/**
 * Created by adefruandta on 8/4/17.
 */

abstract class ViperArrayAdapter<T, V : ViperViewHolder<T>> : ArrayAdapter<T> {

    // region Attributes

    var onItemClickListener: OnItemClickListener<T>? = null

    // endregion

    // region Constructor

    constructor(context: Context,
                @LayoutRes resource: Int) : super(context, resource)

    constructor(context: Context, @LayoutRes resource: Int,
                @IdRes textViewResourceId: Int) : super(context, resource, textViewResourceId)

    constructor(context: Context, @LayoutRes resource: Int, objects: Array<T>) : super(context, resource, objects)

    constructor(context: Context, @LayoutRes resource: Int,
                @IdRes textViewResourceId: Int, objects: Array<T>) : super(context, resource, textViewResourceId, objects)

    constructor(context: Context, @LayoutRes resource: Int,
                objects: List<T>) : super(context, resource, objects)

    constructor(context: Context, @LayoutRes resource: Int,
                @IdRes textViewResourceId: Int, objects: List<T>) : super(context, resource, textViewResourceId, objects)

    // endregion

    // region Life Cycle

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // inflate item if it does not exist yet
        val viewHolder: V
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(itemLayoutResId(getItemViewType(position)), parent, false)
            viewHolder = onCreateViewHolder(getItemViewType(position), itemView)
            itemView.tag = viewHolder
        } else {
            @Suppress("UNCHECKED_CAST")
            viewHolder = itemView.tag as V
        }

        viewHolder.position = position
        viewHolder.onItemClickListener = onItemClickListener
        viewHolder.onBind(getItem(position))

        return itemView as View
    }

    // endregion

    // region Base Adapter

    abstract fun itemLayoutResId(viewType: Int): Int

    abstract fun onCreateViewHolder(viewType: Int, itemView: View): V

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
