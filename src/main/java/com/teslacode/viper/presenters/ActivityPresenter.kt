package com.teslacode.viper.presenters

import android.content.Intent
import android.os.Bundle
import com.teslacode.viper.contracts.ActivityContract.*
import com.teslacode.viper.contracts.BaseContract.Router
import com.teslacode.viper.fragments.BaseFragment

/**
 * Created by adefruandta on 8/13/17.
 */

open class ActivityPresenter<V : ViewBehavior, I : Interactor, R : Router>(view: V?, interactor: I? = null, router: R? = null) :
        BasePresenter<V, I, R>(view, interactor, router), Presenter, InteractorOutput {

    // region Attributes

    protected open var showBackButton: Boolean = false
        set(value) {
            field = value
            prepareBackButton(field)
        }

    protected open var showToolbar: Boolean = true
        set(value) {
            field = value
            prepareToolbar(field)
        }

    // endregion

    // region Presenter

    override fun onCreate(extras: Bundle?, savedInstanceState: Bundle?) {
        prepareToolbar(this.showToolbar)
        prepareBackButton(this.showBackButton)

        this.interactor?.onCreate(extras, savedInstanceState)
    }

    override fun onCreateFragment(hasFragment: Boolean, savedInstanceState: Bundle?) {
        if (!hasFragment) {
            this.view?.createFragment(savedInstanceState)
        }
    }

    override fun <F : BaseFragment<*>> onFragmentCreated(fragment: F?) {
        if (fragment != null) {
            this.view?.showFragment()

        } else {
            this.view?.hideFragment()
        }
    }

    override fun onStart() {
        this.interactor?.onStart()
    }

    override fun onResume() {
        this.interactor?.onResume()
    }

    override fun onStop() {
        this.interactor?.onStop()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        this.interactor?.onActivityResult(requestCode, resultCode, data)
    }

    override fun savedInstanceState(outState: Bundle?) {
        this.interactor?.savedInstanceState(outState)
    }

    // endregion

    // region Methods

    protected open fun prepareToolbar(show: Boolean) {
        if (show) {
            this.view?.showToolbar()
        } else {
            this.view?.hideToolbar()
        }
    }

    protected open fun prepareBackButton(show: Boolean) {
        if (show) {
            this.view?.showBackButton()
        } else {
            this.view?.hideBackButton()
        }
    }

    // endregion
}
