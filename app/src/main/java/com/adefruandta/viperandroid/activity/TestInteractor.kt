package com.adefruandta.viperandroid.activity

import android.os.Bundle
import android.util.Log
import com.adefruandta.viper.interactors.ViperInteractor
import com.adefruandta.viperandroid.activity.TestContract.InteractorOutput

/**
 * Created by adefruandta on 12/15/17.
 */

class TestInteractor : ViperInteractor<InteractorOutput>(), TestContract.Interactor {

    override fun onCreate(extras: Bundle?, savedInstanceState: Bundle?) {
        super.onCreate(extras, savedInstanceState)
        Log.d("VIPER", "Activity.Interactor.onCreate")
    }
}