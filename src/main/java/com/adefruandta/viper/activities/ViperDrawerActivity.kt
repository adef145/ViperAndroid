package com.adefruandta.viper.activities

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import com.adefruandta.viper.R
import com.adefruandta.viper.contracts.ViperDrawerActivityContract.Presenter
import com.adefruandta.viper.contracts.ViperDrawerActivityContract.ViewBehavior
import com.adefruandta.viper.others.bindView

/**
 * Created by adefruandta on 8/19/17.
 */

abstract class ViperDrawerActivity<P : Presenter<*, *, *>> : ViperActivity<P>(), ViewBehavior {

    // region Attributes

    override var layoutResId: Int = R.layout.activity_drawer

    protected lateinit var drawerToggle: ActionBarDrawerToggle

    protected val drawerLayout: DrawerLayout by bindView(R.id.drawerLayout)

    protected val navigationView: NavigationView by bindView(R.id.navigationView)

    protected val isDrawerOpen: Boolean
        get() {
            return drawerLayout.isDrawerOpen(navigationView)
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

        onCreateDrawerMenu(LayoutInflater.from(this), navigationView)
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

    // region Drawer Activity

    open fun onCreateDrawerMenu(inflater: LayoutInflater?, navigationView: NavigationView) {

    }

    // endregion

    // region View Behavior

    override fun closeDrawers() {
        drawerLayout.closeDrawers()
    }

    // endregion
}
