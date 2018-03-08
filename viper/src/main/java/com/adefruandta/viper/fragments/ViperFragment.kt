package com.adefruandta.viper.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.adefruandta.viper.contracts.ViperFragmentContract.Presenter
import com.adefruandta.viper.contracts.ViperFragmentContract.ViewBehavior

/**
 * Created by adefruandta on 8/3/17.
 */

abstract class ViperFragment<P : Presenter<*, *, *>> : Fragment(), ViewBehavior {

    // region Attributes

    protected open var menuResId: Int? = null

    protected open var attachToRoot: Boolean = false

    protected open var layoutResId: Int? = null

    protected open var presenter: P? = null

    protected open val hasOptionsMenu: Boolean
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        if (this.layoutResId == null) {
            return null
        }

        return inflater.inflate(this.layoutResId!!, container, attachToRoot)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(this.menuResId!!, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter?.onSavedInstanceState(outState)
    }

    override fun onDestroy() {
        presenter?.unregister()
        presenter = null
        super.onDestroy()
    }

    // endregion

    // region Base Fragment

    @Suppress("UNCHECKED_CAST")
    open fun onCreatePresenter(savedInstanceState: Bundle?): P? = null

    open fun onPresenterCreated(presenter: P?, savedInstanceState: Bundle?) {
        this.presenter = presenter
        this.presenter?.onCreate(arguments, savedInstanceState)
    }

    // endregion

    // region View Behavior

    override fun setTitle(title: String?) {
        activity?.title = title
    }

    override fun setTitle(titleResId: Int) {
        setTitle(getString(titleResId))
    }

    override fun finishActivity() {
        activity?.finish()
    }

    // endregion
}
