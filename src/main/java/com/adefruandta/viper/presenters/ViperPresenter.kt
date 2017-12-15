package com.adefruandta.viper.presenters

import com.adefruandta.viper.contracts.ViperContract.*

/**
 * Created by adefruandta on 8/3/17.
 */

open class ViperPresenter<V : ViewBehavior, I : Interactor, R : Router> :
        Presenter<V, I, R>, InteractorOutput {

    override var view: V? = null

    override var interactor: I? = null
        set(value) {
            field = value
            field?.setInteractorOutput(this)
        }

    override var router: R? = null

    constructor(view: V, interactor: I? = null, router: R? = null) {
        this.view = view
        this.interactor = interactor
        this.router = router
    }
}
