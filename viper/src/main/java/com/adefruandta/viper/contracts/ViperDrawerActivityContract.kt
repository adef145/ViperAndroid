package com.adefruandta.viper.contracts

import android.os.Bundle

/**
 * Created by adefruandta on 8/20/17.
 */

interface ViperDrawerActivityContract {

    interface ViewBehavior : ViperActivityContract.ViewBehavior {

        fun closeDrawers()
    }

    interface Presenter<V : ViewBehavior, I : Interactor, R : ViperContract.Router> : ViperActivityContract.Presenter<V, I, R> {

        override fun onCreate(extras: Bundle?, savedInstanceState: Bundle?) {
            super.onCreate(extras, savedInstanceState)
            view?.showBackButton()
        }
    }

    interface Interactor : ViperActivityContract.Interactor

    interface InteractorOutput : ViperActivityContract.InteractorOutput

    interface Router : ViperActivityContract.Router
}
