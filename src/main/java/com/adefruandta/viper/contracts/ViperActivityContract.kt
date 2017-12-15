package com.adefruandta.viper.contracts

import android.content.Intent
import android.os.Bundle

/**
 * Created by adefruandta on 8/13/17.
 */

interface ViperActivityContract {

    interface ViewBehavior : ViperContract.ViewBehavior {

        fun setTitle(title: String?)

        fun setTitle(titleResId: Int)

        fun showToolbar()

        fun hideToolbar()

        fun showBackButton()

        fun hideBackButton()
    }

    interface Presenter<V : ViewBehavior, I : Interactor, R : ViperContract.Router> : ViperContract.Presenter<V, I, R> {

        fun onCreate(extras: Bundle?, savedInstanceState: Bundle?) {
            interactor?.onCreate(extras, savedInstanceState)
        }

        fun onPostCreate() {
            interactor?.onPostCreate()
        }

        fun onStart() {
            interactor?.onStart()
        }

        fun onResume() {
            interactor?.onResume()
        }

        fun onStop() {
            interactor?.onStop()
        }

        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            interactor?.onActivityResult(requestCode, resultCode, data)
        }

        fun onSavedInstanceState(outState: Bundle?) {
            interactor?.onSavedInstanceState(outState)
        }
    }

    interface Interactor : ViperContract.Interactor {

        fun onCreate(extras: Bundle?, savedInstanceState: Bundle?) {

        }

        fun onPostCreate() {

        }

        fun onStart() {

        }

        fun onResume() {

        }

        fun onStop() {

        }

        fun onBackPressed() {

        }

        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        }

        fun onSavedInstanceState(outState: Bundle?) {

        }
    }

    interface InteractorOutput : ViperContract.InteractorOutput

    interface Router : ViperContract.Router
}
