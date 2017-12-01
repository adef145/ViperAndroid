package com.adefruandta.viper.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.adefruandta.viper.R
import com.adefruandta.viper.contracts.ViperActivityContract.*
import com.adefruandta.viper.contracts.ViperContract.Router
import com.adefruandta.viper.fragments.ViperFragment
import com.adefruandta.viper.interactors.ViperActivityInteractor
import com.adefruandta.viper.others.bindView
import com.adefruandta.viper.presenters.ViperActivityPresenter
import com.adefruandta.viper.routers.ViperRouter

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

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        presenter?.onSavedInstanceState(outState)
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

    open fun onRestoreFragment(savedInstanceState: Bundle?): F? {
        return supportFragmentManager.findFragmentById(containerResId) as F?
    }

    open fun onFragmentRestored(fragment: F?) {
        this.fragment = fragment
    }

    open fun onCreateFragment(savedInstanceState: Bundle?): F? = null

    open fun onFragmentCreated(fragment: F?) {
        this.fragment = fragment
        this.presenter?.onFragmentCreated(this.fragment)
    }

    @Suppress("UNCHECKED_CAST")
    open fun onCreatePresenter(savedInstanceState: Bundle?): P? = ViperActivityPresenter<ViewBehavior, Interactor, Router>(this, ViperActivityInteractor<InteractorOutput>(), ViperRouter(this)) as P

    open fun onPresenterCreated(presenter: P?, savedInstanceState: Bundle?) {
        this.presenter = presenter
        this.presenter?.onCreate(intent.extras, savedInstanceState)
        this.presenter?.onCreateFragment(hasFragment, savedInstanceState)
    }

    // endregion

    // region View Behavior

    override fun setTitle(title: String?) {
        this.title = title
    }

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

    override fun restoreFragment(savedInstanceState: Bundle?) {
        onFragmentRestored(onRestoreFragment(savedInstanceState))
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
