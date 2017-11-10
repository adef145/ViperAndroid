package com.teslacode.viper.presenters

import com.teslacode.viper.contracts.BaseContract.*

/**
 * Created by adefruandta on 8/3/17.
 */

open class BasePresenter<V : ViewBehavior, I : Interactor, R : Router> :
        Presenter, InteractorOutput {

    // region Attributes

    protected var view: V? = null

    protected var interactor: I? = null
        set(value) {
            value?.setInteractorOutput(this)
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
