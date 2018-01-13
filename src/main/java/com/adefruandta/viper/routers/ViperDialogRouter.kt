package com.adefruandta.viper.routers

import android.app.Activity
import android.content.Context
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity

/**
 * Created by adefruandta on 1/12/18.
 */
open class ViperDialogRouter : ViperRouter {

    protected open val tag: String = ViperDialogRouter::class.java.simpleName

    protected open var dialog: DialogFragment? = null

    protected open val fragmentManager: FragmentManager?
        get() {
            if (activity != null && activity is AppCompatActivity) {
                return (activity as AppCompatActivity)?.supportFragmentManager
            }

            if (fragment != null) {
                return fragment?.fragmentManager
            }

            return null
        }

    constructor(activity: Activity) : super(activity)

    constructor(fragment: Fragment) : super(fragment)

    constructor(context: Context) : super(context)

    constructor(router: ViperRouter) : super(router)

    open fun show(checkAdded: Boolean = true): DialogFragment? {
        if (checkAdded && dialog?.isAdded == true) {
            return dialog
        }

        if (fragmentManager != null) {
            dialog?.show(fragmentManager, tag)
        }
        
        return dialog
    }
}