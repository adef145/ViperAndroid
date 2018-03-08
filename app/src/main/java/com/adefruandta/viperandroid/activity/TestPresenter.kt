package com.adefruandta.viperandroid.activity

import android.os.Bundle
import android.util.Log
import com.adefruandta.viper.presenters.ViperPresenter
import com.adefruandta.viperandroid.activity.TestContract.*

/**
 * Created by adefruandta on 12/15/17.
 */
class TestPresenter(view: ViewBehavior, interactor: Interactor, router: Router) : ViperPresenter<ViewBehavior, Interactor, Router>(view, interactor, router), Presenter, InteractorOutput {

    override fun onCreate(extras: Bundle?, savedInstanceState: Bundle?) {
        super.onCreate(extras, savedInstanceState)
        Log.d("VIPER", "Activity.Presenter.onCreate")
        router?.openActivity2()
    }
}