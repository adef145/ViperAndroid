package com.teslacode.viper.contracts

/**
 * Created by adefruandta on 8/20/17.
 */

interface DrawerActivityContract {

    interface ViewBehavior : ActivityContract.ViewBehavior {

        fun closeDrawers()
    }

    interface Presenter : ActivityContract.Presenter

    interface Interactor : ActivityContract.Interactor

    interface InteractorOutput : ActivityContract.InteractorOutput
}
