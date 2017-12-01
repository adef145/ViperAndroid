package com.adefruandta.viper.presenters

import com.adefruandta.viper.contracts.ViperContract.Router
import com.adefruandta.viper.contracts.ViperDrawerActivityContract.*

/**
 * Created by adefruandta on 10/6/17.
 */

open class ViperDrawerActivityPresenter<V : ViewBehavior, I : Interactor, R : Router>(view: V?, interactor: I? = null, router: R? = null) :
        ViperActivityPresenter<V, I, R>(view, interactor, router), Presenter, InteractorOutput {

    // region Attributes

    override var showBackButton: Boolean = true

    // endregion
}
