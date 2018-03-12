package com.adefruandta.viper.activities

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.ViewGroup
import com.adefruandta.viper.R
import com.adefruandta.viper.contracts.ViperActivityContract.Presenter
import com.adefruandta.viper.contracts.ViperActivityContract.ViewBehavior
import com.adefruandta.viper.others.bindOptionalView

/**
 * Created by adefruandta on 8/3/17.
 */

open class ViperActivity<P : Presenter<*, *, *>> : AppCompatActivity(), ViewBehavior {

    // region Attributes

    protected open var containerResId: Int = R.id.container

    protected open var layoutResId: Int = R.layout.activity_base

    protected open var fragment: Fragment? = null

    protected open var presenter: P? = null

    protected open val container: ViewGroup? by bindOptionalView(containerResId)

    // endregion

    // region Life Cycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        onPresenterCreated(onCreatePresenter(savedInstanceState), savedInstanceState)
        onPrepareFragment(savedInstanceState)
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

    override fun onBackPressed() {
        super.onBackPressed()
        presenter?.onBackPressed()
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

    protected open fun onRestoreFragment(savedInstanceState: Bundle?): Fragment? {
        return supportFragmentManager.findFragmentById(containerResId)
    }

    protected open fun onCreateFragment(savedInstanceState: Bundle?): Fragment? = null

    protected open fun onFragmentCreated(fragment: Fragment?) {
        if (fragment == null) {
            return
        }

        supportFragmentManager.beginTransaction().add(containerResId, fragment, null).commit()
    }

    @Suppress("UNCHECKED_CAST")
    protected open fun onCreatePresenter(savedInstanceState: Bundle?): P? = null

    protected open fun onPresenterCreated(presenter: P?, savedInstanceState: Bundle?) {
        this.presenter = presenter
        this.presenter?.onCreate(intent.extras, savedInstanceState)
    }

    protected open fun onPrepareFragment(savedInstanceState: Bundle?) {
        if (container == null) {
            return
        }

        this.fragment = onRestoreFragment(savedInstanceState)

        if (this.fragment == null) {
            this.fragment = onCreateFragment(savedInstanceState)
            onFragmentCreated(this.fragment)
        }
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

    // endregion
}
