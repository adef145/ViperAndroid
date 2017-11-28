package com.teslacode.viper.presenters

import com.teslacode.viper.contracts.ViperContract.Router
import com.teslacode.viper.contracts.ViperDrawerActivityContract.*

/**
 * Created by adefruandta on 10/6/17.
 */

open class ViperDrawerActivityPresenter<V : ViewBehavior, I : Interactor, R : Router>(view: V?, interactor: I? = null, router: R? = null) :
        ViperActivityPresenter<V, I, R>(view, interactor, router), Presenter, InteractorOutput {

    // region Attributes

    override var showBackButton: Boolean = true

    // endregion
}
