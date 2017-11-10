package com.teslacode.viper.contracts

/**
 * Created by adefruandta on 10/23/17.
 */

interface ToolbarExtendedActivityContract {

    interface ViewBehavior : ActivityContract.ViewBehavior

    interface Presenter : ActivityContract.Presenter

    interface Interactor : ActivityContract.Interactor

    interface InteractorOutput : ActivityContract.InteractorOutput
}
