package com.teslacode.viper.activities

import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.teslacode.viper.R
import com.teslacode.viper.contracts.BaseContract.Router
import com.teslacode.viper.contracts.DrawerActivityContract.*
import com.teslacode.viper.fragments.BaseFragment
import com.teslacode.viper.interactors.DrawerActivityInteractor
import com.teslacode.viper.others.bindView
import com.teslacode.viper.presenters.DrawerActivityPresenter
import com.teslacode.viper.routers.BaseRouter

/**
 * Created by adefruandta on 8/19/17.
 */

abstract class DrawerActivity<F : BaseFragment<*>, P : Presenter> : BaseActivity<F, P>(), ViewBehavior {

    // region Attributes

    override var layoutResId: Int = R.layout.activity_drawer

    protected lateinit var drawerToggle: ActionBarDrawerToggle

    protected val drawerLayout: DrawerLayout by bindView(R.id.drawerLayout)

    protected val drawerMenuContainer: ViewGroup by bindView(R.id.drawerMenuContainer)

    protected val isDrawerOpen: Boolean
        get() {
            return drawerLayout.isDrawerOpen(drawerMenuContainer)
        }

    // endregion

    // region Life Cycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        drawerToggle = object : ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close) {
            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)

                invalidateOptionsMenu()
            }

            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)

                invalidateOptionsMenu()
            }
        }

        drawerLayout.addDrawerListener(drawerToggle)

        onCreateDrawerMenu(LayoutInflater.from(this), drawerMenuContainer)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Pass the event to ActionBarDrawerToggle
        // If it returns true, then it has handled
        // the nav drawer indicator touch event
        return if (drawerToggle.onOptionsItemSelected(item)) {
            true
        } else {
            // Handle your other action bar items...
            super.onOptionsItemSelected(item)
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle.syncState()
    }

    override fun onBackPressed() {
        if (isDrawerOpen) {
            closeDrawers()
        } else {
            super.onBackPressed()
        }
    }

    // endregion

    // region Base Activity

    @Suppress("UNCHECKED_CAST")
    override fun onCreatePresenter(savedInstanceState: Bundle?): P? = DrawerActivityPresenter<ViewBehavior, Interactor, Router>(this, DrawerActivityInteractor<InteractorOutput>(), BaseRouter(this)) as P

    // endregion

    // region Drawer Activity

    open fun onCreateDrawerMenu(inflater: LayoutInflater?, container: ViewGroup) {

    }

    // endregion

    // region View Behavior

    override fun closeDrawers() {
        drawerLayout.closeDrawers()
    }

    // endregion
}
