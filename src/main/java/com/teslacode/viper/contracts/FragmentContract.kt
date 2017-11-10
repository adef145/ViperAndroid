package com.teslacode.viper.contracts

import android.content.Intent
import android.os.Bundle

/**
 * Created by adefruandta on 8/8/17.
 */

interface FragmentContract : BaseContract {

    interface ViewBehavior : BaseContract.ViewBehavior {

        fun setTitle(title: String?)

        fun setTitle(titleResId: Int)

        fun finishActivity()
    }

    interface Presenter : BaseContract.Presenter {

        fun onCreate(extras: Bundle?, savedInstanceState: Bundle?)

        fun onViewCreated()

        fun onStart()

        fun onResume()

        fun onStop()

        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)

        fun savedInstanceState(outState: Bundle?)
    }

    interface Interactor : BaseContract.Interactor {

        fun onCreate(extras: Bundle?, savedInstanceState: Bundle?)

        fun onViewCreated()

        fun onStart()

        fun onResume()

        fun onStop()

        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)

        fun onSavedInstanceState(outState: Bundle?)
    }

    interface InteractorOutput : BaseContract.InteractorOutput {

        fun finishActivity()
    }
}
