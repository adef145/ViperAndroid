package com.teslacode.viper.contracts

/**
 * Created by adefruandta on 8/20/17.
 */

interface ViperDrawerActivityContract {

    interface ViewBehavior : ViperActivityContract.ViewBehavior {

        fun closeDrawers()
    }

    interface Presenter : ViperActivityContract.Presenter

    interface Interactor : ViperActivityContract.Interactor

    interface InteractorOutput : ViperActivityContract.InteractorOutput
}
