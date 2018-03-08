package com.adefruandta.viperandroid.activity

import android.app.Activity
import android.content.Intent
import com.adefruandta.viper.routers.ViperRouter
import com.adefruandta.viperandroid.activity.TestContract.Router
import com.adefruandta.viperandroid.activity2.TestRouter2

/**
 * Created by adefruandta on 12/15/17.
 */
class TestRouter(activity: Activity) : ViperRouter(activity), Router {

    override var intent: Intent = Intent(context, TestActivity::class.java)

    override fun openActivity2() {
        val router = TestRouter2(this)
        router.open()
    }
}