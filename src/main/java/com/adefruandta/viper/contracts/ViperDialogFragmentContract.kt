package com.adefruandta.viper.contracts

/**
 * Created by adefruandta on 8/16/17.
 */

interface ViperDialogFragmentContract {

    interface ViewBehavior : ViperFragmentContract.ViewBehavior {

        fun dismiss()
    }

    interface Presenter<V : ViewBehavior, I : Interactor, R : ViperContract.Router> : ViperFragmentContract.Presenter<V, I, R>

    interface Interactor : ViperFragmentContract.Interactor

    interface InteractorOutput : ViperFragmentContract.InteractorOutput

    interface Router : ViperFragmentContract.Router
}
