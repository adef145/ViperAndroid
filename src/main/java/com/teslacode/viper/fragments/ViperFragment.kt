package com.teslacode.viper.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.teslacode.viper.contracts.Contract.Router
import com.teslacode.viper.contracts.FragmentContract.*
import com.teslacode.viper.interactors.FragmentInteractor
import com.teslacode.viper.presenters.FragmentPresenter
import com.teslacode.viper.routers.ViperRouter

/**
 * Created by adefruandta on 8/3/17.
 */

abstract class ViperFragment<T : Presenter> : Fragment(), ViewBehavior {

    // region Attributes

    protected open var menuResId: Int? = null

    protected open var attachToRoot: Boolean = false

    protected abstract var layoutResId: Int

    protected var presenter: T? = null

    protected val hasOptionsMenu: Boolean
        get() {
            return menuResId != null && menuResId != 0
        }

    // endregion

    // region Life Cycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(hasOptionsMenu)
        onPresenterCreated(onCreatePresenter(savedInstanceState), savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(this.layoutResId, container, attachToRoot)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(this.menuResId!!, menu)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter?.onActivityResult(requestCode, resultCode, data)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        presenter?.savedInstanceState(outState)
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
        return FragmentPresenter<ViewBehavior, Interactor, Router>(this, FragmentInteractor<InteractorOutput>(), ViperRouter(this)) as T
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
