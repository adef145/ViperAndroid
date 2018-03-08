package com.adefruandta.viper.contracts

/**
 * Created by adefruandta on 8/7/17.
 */

interface ViperContract {

    interface ViewBehavior

    interface Presenter<V : ViewBehavior, I : Interactor, R : Router> {

        var view: V?

        var interactor: I?

        var router: R?

        fun unregister() {
            this.interactor?.unregister()
            this.router?.unregister()
            this.view = null
        }
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
