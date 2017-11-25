package com.teslacode.viper.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.teslacode.viper.R
import com.teslacode.viper.contracts.ActivityContract.*
import com.teslacode.viper.contracts.Contract.Router
import com.teslacode.viper.fragments.ViperFragment
import com.teslacode.viper.interactors.ActivityInteractor
import com.teslacode.viper.others.bindView
import com.teslacode.viper.presenters.ActivityPresenter
import com.teslacode.viper.routers.ViperRouter

/**
 * Created by adefruandta on 8/3/17.
 */

open class ViperActivity<F : ViperFragment<*>, P : Presenter> : AppCompatActivity(), ViewBehavior {

    // region Attributes

    protected open var containerResId: Int = R.id.container

    protected open var layoutResId: Int = R.layout.activity_base

    protected var fragment: F? = null

    protected var presenter: P? = null

    protected val container: ViewGroup by bindView(containerResId)

    protected val hasFragment: Boolean
        get() {
            return supportFragmentManager.findFragmentById(containerResId) != null
        }

    // endregion

    // region Life Cycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        onPresenterCreated(onCreatePresenter(savedInstanceState), savedInstanceState)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        presenter?.onPostCreate()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == android.R.id.home) {
            onBackPressed()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
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

    override fun onDestroy() {
        presenter?.unregister()
        presenter = null
        super.onDestroy()
    }

    // endregion

    // region Base Activity

    open fun onCreateFragment(savedInstanceState: Bundle?): F? = null

    open fun onFragmentCreated(fragment: F?) {
        this.fragment = fragment
        this.presenter?.onFragmentCreated(this.fragment)
    }

    @Suppress("UNCHECKED_CAST")
    open fun onCreatePresenter(savedInstanceState: Bundle?): P? = ActivityPresenter<ViewBehavior, Interactor, Router>(this, ActivityInteractor<InteractorOutput>(), ViperRouter(this)) as P

    open fun onPresenterCreated(presenter: P?, savedInstanceState: Bundle?) {
        this.presenter = presenter
        this.presenter?.onCreate(intent.extras, savedInstanceState)
        this.presenter?.onCreateFragment(hasFragment, savedInstanceState)
    }

    // endregion

    // region View Behavior

    override fun showToolbar() {
        this.supportActionBar?.show()
        invalidateOptionsMenu()
    }

    override fun hideToolbar() {
        this.supportActionBar?.hide()
        invalidateOptionsMenu()
    }

    override fun showBackButton() {
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        invalidateOptionsMenu()
    }

    override fun hideBackButton() {
        this.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        invalidateOptionsMenu()
    }

    override fun createFragment(savedInstanceState: Bundle?) {
        onFragmentCreated(onCreateFragment(savedInstanceState))
    }

    override fun showFragment() {
        this.container.visibility = View.VISIBLE
        supportFragmentManager.beginTransaction().add(containerResId, this.fragment, null).commit()
    }

    override fun hideFragment() {
        this.container.visibility = View.GONE
    }

    // endregion
}
