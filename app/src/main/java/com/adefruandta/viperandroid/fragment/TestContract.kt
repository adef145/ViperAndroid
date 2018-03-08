package com.adefruandta.viperandroid.fragment

import com.adefruandta.viper.contracts.ViperFragmentContract

/**
 * Created by adefruandta on 12/15/17.
 */
interface TestContract {

    interface ViewBehavior : ViperFragmentContract.ViewBehavior

    interface Presenter : ViperFragmentContract.Presenter<ViewBehavior, Interactor, Router>

    interface Interactor : ViperFragmentContract.Interactor

    interface InteractorOutput : ViperFragmentContract.InteractorOutput

    interface Router : ViperFragmentContract.Router
}