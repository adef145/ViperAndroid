package com.teslacode.viper.presenters

import com.teslacode.viper.contracts.Contract.Router
import com.teslacode.viper.contracts.DrawerActivityContract.*

/**
 * Created by adefruandta on 10/6/17.
 */

open class DrawerActivityPresenter<V : ViewBehavior, I : Interactor, R : Router>(view: V?, interactor: I? = null, router: R? = null) :
        ActivityPresenter<V, I, R>(view, interactor, router), Presenter, InteractorOutput {

    // region Attributes

    override var showBackButton: Boolean = true

    // endregion
}
