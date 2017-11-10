package com.teslacode.viper.viewgroups

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.teslacode.viper.contracts.BaseContract.Presenter

/**
 * Created by adefruandta on 8/4/17.
 */

open class BaseLinearLayout<T : Presenter> : LinearLayout {

    // region Attributes

    var presenter: T? = null

    // endregion

    // region Constructor

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context, attrs)
    }

    // endregion

    // region Life Cycle

    override fun onDetachedFromWindow() {
        presenter?.unregister()
        super.onDetachedFromWindow()
    }

    // endregion

    // region Base Layout

    open fun init(context: Context, attrs: AttributeSet?) {
        onPresenterCreated(onCreatePresenter())

        initAttrs(attrs)
        initView(context)
    }

    open fun initAttrs(attrs: AttributeSet?) {

    }

    open fun initView(context: Context) {
        if (layoutResId().equals(0)) {
            return
        }

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(layoutResId(), this)
    }

    open fun layoutResId(): Int = 0

    open fun onCreatePresenter(): T? = null

    open fun onPresenterCreated(presenter: T?) {
        this.presenter = presenter
    }

    // endregion
}
