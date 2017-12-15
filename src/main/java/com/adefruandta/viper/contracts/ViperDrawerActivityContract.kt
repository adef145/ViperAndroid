package com.adefruandta.viper.contracts

/**
 * Created by adefruandta on 8/20/17.
 */

interface ViperDrawerActivityContract {

    interface ViewBehavior : ViperActivityContract.ViewBehavior {

        fun closeDrawers()
    }

    interface Presenter<V : ViewBehavior, I : Interactor, R : ViperContract.Router> : ViperActivityContract.Presenter<V, I, R>

    interface Interactor : ViperActivityContract.Interactor

    interface InteractorOutput : ViperActivityContract.InteractorOutput

    interface Router : ViperActivityContract.Router
}
