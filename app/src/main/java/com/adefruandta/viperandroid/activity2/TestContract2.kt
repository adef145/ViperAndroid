package com.adefruandta.viperandroid.activity2

import com.adefruandta.viper.contracts.ViperDrawerActivityContract

/**
 * Created by adefruandta on 12/15/17.
 */

interface TestContract2 {

    interface ViewBehavior : ViperDrawerActivityContract.ViewBehavior

    interface Presenter : ViperDrawerActivityContract.Presenter<ViewBehavior, Interactor, Router>

    interface Interactor : ViperDrawerActivityContract.Interactor

    interface InteractorOutput : ViperDrawerActivityContract.InteractorOutput

    interface Router : ViperDrawerActivityContract.Router
}
