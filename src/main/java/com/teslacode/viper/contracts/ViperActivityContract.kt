package com.teslacode.viper.contracts

import android.content.Intent
import android.os.Bundle
import com.teslacode.viper.fragments.ViperFragment

/**
 * Created by adefruandta on 8/13/17.
 */

interface ViperActivityContract {

    interface ViewBehavior : ViperContract.ViewBehavior {

        fun showToolbar()

        fun hideToolbar()

        fun showBackButton()

        fun hideBackButton()

        fun createFragment(savedInstanceState: Bundle?)

        fun showFragment()

        fun hideFragment()
    }

    interface Presenter : ViperContract.Presenter {

        fun onCreate(extras: Bundle?, savedInstanceState: Bundle?)

        fun onCreateFragment(hasFragment: Boolean, savedInstanceState: Bundle?)

        fun <F : ViperFragment<*>> onFragmentCreated(fragment: F?)

        fun onPostCreate()

        fun onStart()

        fun onResume()

        fun onStop()

        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)

        fun onSavedInstanceState(outState: Bundle?)
    }

    interface Interactor : ViperContract.Interactor {

        fun onCreate(extras: Bundle?, savedInstanceState: Bundle?)

        fun onPostCreate()

        fun onStart()

        fun onResume()

        fun onStop()

        fun onBackPressed()

        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)

        fun onSavedInstanceState(outState: Bundle?)
    }

    interface InteractorOutput : ViperContract.InteractorOutput
}
