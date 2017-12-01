package com.adefruandta.viper.presenters

import android.app.Dialog
import com.adefruandta.viper.contracts.ViperContract.Router
import com.adefruandta.viper.contracts.ViperDialogFragmentContract.*

/**
 * Created by adefruandta on 8/16/17.
 */

open class ViperDialogFragmentPresenter<V : ViewBehavior, I : Interactor, R : Router>(view: V?, interactor: I? = null, router: R? = null) : ViperFragmentPresenter<V, I, R>(view, interactor, router), Presenter, InteractorOutput {

    // region Presenter

    override fun onCreateDialog(): Dialog? {
        return null
    }

    // endregion

    // region Interactor Output

    override fun dismiss() {
        view?.dismiss()
    }

    // endregion
}
