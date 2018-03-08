package com.adefruandta.viperandroid.fragment

import android.support.v4.app.Fragment
import com.adefruandta.viper.routers.ViperRouter
import com.adefruandta.viperandroid.fragment.TestContract.Router

/**
 * Created by adefruandta on 12/15/17.
 */

class TestRouter(fragment: Fragment) : ViperRouter(fragment), Router {
}