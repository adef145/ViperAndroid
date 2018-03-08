package com.adefruandta.viperandroid.fragment

import android.os.Bundle
import com.adefruandta.viper.fragments.ViperFragment
import com.adefruandta.viperandroid.fragment.TestContract.Presenter
import com.adefruandta.viperandroid.fragment.TestContract.ViewBehavior

/**
 * Created by adefruandta on 12/15/17.
 */

class TestFragment : ViperFragment<Presenter>(), ViewBehavior {

    override var layoutResId: Int? = null

    override fun onCreatePresenter(savedInstanceState: Bundle?): Presenter? {
        return TestPresenter(this, TestInteractor(), TestRouter(this))
    }
}