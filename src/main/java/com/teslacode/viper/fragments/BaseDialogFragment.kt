package com.teslacode.viper.fragments

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import com.teslacode.viper.contracts.BaseContract.Router
import com.teslacode.viper.contracts.DialogFragmentContract.*
import com.teslacode.viper.interactors.DialogFragmentInteractor
import com.teslacode.viper.presenters.DialogFragmentPresenter
import com.teslacode.viper.routers.BaseRouter

/**
 * Created by adefruandta on 8/15/17.
 */

open class BaseDialogFragment<T : Presenter> : DialogFragment(), ViewBehavior {

    // region Attributes

    internal var presenter: T? = null

    // endregion

    // region Life Cycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onPresenterCreated(onCreatePresenter(savedInstanceState), savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        presenter?.onStart()
    }

    override fun onResume() {
        super.onResume()
        presenter?.onResume()
    }

    override fun onStop() {
        super.onStop()
        presenter?.onStop()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return presenter?.onCreateDialog() ?: super.onCreateDialog(savedInstanceState)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter?.onActivityResult(requestCode, resultCode, data)
    }

    override fun onDestroy() {
        presenter?.unregister()
        presenter = null
        super.onDestroy()
    }

    // endregion

    // region Base Fragment

    @Suppress("UNCHECKED_CAST")
    open fun onCreatePresenter(savedInstanceState: Bundle?): T {
        return DialogFragmentPresenter<ViewBehavior, Interactor, Router>(this, DialogFragmentInteractor<InteractorOutput>(), BaseRouter(this)) as T
    }

    open fun onPresenterCreated(presenter: T, savedInstanceState: Bundle?) {
        this.presenter = presenter
        this.presenter?.onCreate(arguments, savedInstanceState)
    }

    // endregion

    // region View Behavior

    override fun setTitle(title: String?) {
        activity.title = title
    }

    override fun setTitle(titleResId: Int) {
        setTitle(getString(titleResId))
    }

    override fun finishActivity() = activity.finish()

    override fun hide() {
        dismiss()
    }

    // endregion
}
