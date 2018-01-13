package com.adefruandta.viper.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adefruandta.viper.listeners.OnItemClickListener
import com.adefruandta.viper.viewholders.ViperRecyclerViewHolder

/**
 * Created by adefruandta on 8/13/17.
 */

abstract class ViperRecyclerViewAdapter<T, V : ViperRecyclerViewHolder<T>> : RecyclerView.Adapter<V>() {

    // region Attributes

    open var data: List<T>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    open var onItemClickListener: OnItemClickListener<T>? = null

    // endregion

    // region Life Cycle

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): V? {
        val view = LayoutInflater.from(parent.context).inflate(itemLayoutResId(viewType), parent, false)
        return createViewHolder(view, viewType)
    }

    override fun onBindViewHolder(holder: V, position: Int) {
        holder.onItemClickListener = onItemClickListener
        holder.onBind(data!![position])
    }

    override fun getItemCount(): Int = data?.size ?: 0

    // endregion

    // region Base Adapter

    abstract fun createViewHolder(view: View, viewType: Int): V

    abstract fun itemLayoutResId(viewType: Int): Int

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
