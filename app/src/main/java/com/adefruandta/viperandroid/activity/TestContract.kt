package com.adefruandta.viperandroid.activity

import com.adefruandta.viper.contracts.ViperDrawerActivityContract

/**
 * Created by adefruandta on 12/15/17.
 */

interface TestContract {

    interface ViewBehavior : ViperDrawerActivityContract.ViewBehavior

    interface Presenter : ViperDrawerActivityContract.Presenter<ViewBehavior, Interactor, Router>

    interface Interactor : ViperDrawerActivityContract.Interactor

    interface InteractorOutput : ViperDrawerActivityContract.InteractorOutput

    interface Router : ViperDrawerActivityContract.Router {

        fun openActivity2()
    }
}
