package com.adefruandta.viper.presenters

import com.adefruandta.viper.contracts.ViperContract.*

/**
 * Created by adefruandta on 8/3/17.
 */

open class ViperPresenter<V : ViewBehavior, I : Interactor, R : Router> :
        Presenter, InteractorOutput {

    // region Attributes

    protected var view: V? = null

    protected var interactor: I? = null
        set(value) {
            value?.setInteractorOutput(this)
            field = value
        }

    protected var router: R? = null

    // endregion

    constructor(view: V?, interactor: I? = null, router: R? = null) {
        this.view = view
        this.interactor = interactor
        this.router = router
    }

    override fun unregister() {
        interactor?.unregister()
        router?.unregister()
        view = null
    }
}
