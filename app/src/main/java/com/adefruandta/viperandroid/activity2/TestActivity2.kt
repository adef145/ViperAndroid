package com.adefruandta.viperandroid.activity2

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.widget.TextView
import com.adefruandta.viper.activities.ViperDrawerActivity
import com.adefruandta.viper.others.bindView
import com.adefruandta.viperandroid.R
import com.adefruandta.viperandroid.activity2.TestContract2.Presenter
import com.adefruandta.viperandroid.fragment.TestFragment

/**
 * Created by adefruandta on 12/15/17.
 */

class TestActivity2 : ViperDrawerActivity<Presenter>(), TestContract2.ViewBehavior {

    val tvTest: TextView by bindView(R.id.tvTest)

    override fun onCreateDrawerMenu(inflater: LayoutInflater?, navigationView: NavigationView) {
        inflater?.inflate(R.layout.widget_drawer_menu, navigationView)
    }

    override fun onCreatePresenter(savedInstanceState: Bundle?): Presenter? {
        return TestPresenter2(this, TestInteractor2(), TestRouter2(this))
    }

    override fun onCreateFragment(savedInstanceState: Bundle?): Fragment? {
        return TestFragment()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        tvTest.text = "ABC"
    }
}
