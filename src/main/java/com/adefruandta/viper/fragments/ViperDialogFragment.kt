package com.adefruandta.viper.fragments

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adefruandta.viper.contracts.ViperContract.Router
import com.adefruandta.viper.contracts.ViperDialogFragmentContract.*
import com.adefruandta.viper.interactors.ViperDialogFragmentInteractor
import com.adefruandta.viper.presenters.ViperDialogFragmentPresenter
import com.adefruandta.viper.routers.ViperRouter

/**
 * Created by adefruandta on 8/15/17.
 */

open class ViperDialogFragment<T : Presenter> : DialogFragment(), ViewBehavior {

    // region Attributes

    protected var presenter: T? = null

    protected var layoutResId: Int? = null

    // endregion

    // region Life Cycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onPresenterCreated(onCreatePresenter(savedInstanceState), savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (layoutResId != null) {
            return inflater?.inflate(layoutResId!!, container, false)
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.onViewCreated()
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

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        presenter?.onSavedInstanceState(outState)
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
        return ViperDialogFragmentPresenter<ViewBehavior, Interactor, Router>(this, ViperDialogFragmentInteractor<InteractorOutput>(), ViperRouter(this)) as T
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

    // endregion
}
