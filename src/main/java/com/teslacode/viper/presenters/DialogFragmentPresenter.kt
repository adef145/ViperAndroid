package com.teslacode.viper.presenters

import android.app.Dialog
import com.teslacode.viper.contracts.Contract.Router
import com.teslacode.viper.contracts.DialogFragmentContract.*

/**
 * Created by adefruandta on 8/16/17.
 */

open class DialogFragmentPresenter<V : ViewBehavior, I : Interactor, R : Router>(view: V?, interactor: I? = null, router: R? = null) : FragmentPresenter<V, I, R>(view, interactor, router), Presenter, InteractorOutput {

    // region Presenter

    override fun onCreateDialog(): Dialog? {
        return null
    }

    // endregion

    // region Interactor Output

    override fun hide() {
        view?.hide()
    }

    // endregion
}
