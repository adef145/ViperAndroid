package com.adefruandta.viperandroid.activity

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import com.adefruandta.viper.activities.ViperDrawerActivity
import com.adefruandta.viperandroid.R
import com.adefruandta.viperandroid.activity.TestContract.Presenter
import com.adefruandta.viperandroid.fragment.TestFragment

/**
 * Created by adefruandta on 12/15/17.
 */

class TestActivity : ViperDrawerActivity<Presenter>(), TestContract.ViewBehavior {

    override fun onCreateDrawerMenu(inflater: LayoutInflater?, navigationView: NavigationView) {
        inflater?.inflate(R.layout.widget_drawer_menu, navigationView)
    }

    override fun onCreatePresenter(savedInstanceState: Bundle?): Presenter? {
        return TestPresenter(this, TestInteractor(), TestRouter(this))
    }

    override fun onCreateFragment(savedInstanceState: Bundle?): Fragment? {
        return TestFragment()
    }
}
