package com.adefruandta.viperandroid.activity2

import android.app.Activity
import android.content.Intent
import com.adefruandta.viper.routers.ViperRouter
import com.adefruandta.viperandroid.activity2.TestContract2.Router

/**
 * Created by adefruandta on 12/15/17.
 */
class TestRouter2 : ViperRouter, Router {

    constructor(activity: Activity) : super(activity)

    constructor(router: ViperRouter) : super(router)

    override var intent: Intent = Intent(context, TestActivity2::class.java)
}