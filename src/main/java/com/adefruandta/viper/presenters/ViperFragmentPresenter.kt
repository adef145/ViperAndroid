package com.adefruandta.viper.presenters

import android.content.Intent
import android.os.Bundle
import com.adefruandta.viper.contracts.ViperContract.Router
import com.adefruandta.viper.contracts.ViperFragmentContract.*

/**
 * Created by adefruandta on 8/8/17.
 */

open class ViperFragmentPresenter<V : ViewBehavior, I : Interactor, R : Router>(view: V?, interactor: I? = null, router: R? = null) :
        ViperPresenter<V, I, R>(view, interactor, router), Presenter, InteractorOutput {

    // region Presenter

    override fun onCreate(extras: Bundle?, savedInstanceState: Bundle?) {
        interactor?.onCreate(extras, savedInstanceState)
    }

    override fun onStart() {
        interactor?.onStart()
    }

    override fun onResume() {
        interactor?.onResume()
    }

    override fun onStop() {
        interactor?.onStop()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        interactor?.onActivityResult(requestCode, resultCode, data)
    }

    override fun onSavedInstanceState(outState: Bundle?) {
        interactor?.onSavedInstanceState(outState)
    }

    override fun onViewCreated() {
        interactor?.onViewCreated()
    }

    // endregion

    // region Interactor Output

    override fun finishActivity() {
        view?.finishActivity()
    }

    // endregion
}
