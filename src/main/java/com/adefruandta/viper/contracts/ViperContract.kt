package com.adefruandta.viper.contracts

/**
 * Created by adefruandta on 8/7/17.
 */

interface ViperContract {

    interface ViewBehavior

    interface Presenter {

        fun unregister()
    }

    interface Interactor {

        fun setInteractorOutput(output: InteractorOutput)

        fun unregister()
    }

    interface InteractorOutput

    interface Router {

        fun unregister()
    }
}
