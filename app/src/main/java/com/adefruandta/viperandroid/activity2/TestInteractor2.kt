package com.adefruandta.viperandroid.activity2

import android.os.Bundle
import android.util.Log
import com.adefruandta.viper.interactors.ViperInteractor
import com.adefruandta.viperandroid.activity2.TestContract2.InteractorOutput

/**
 * Created by adefruandta on 12/15/17.
 */

class TestInteractor2 : ViperInteractor<InteractorOutput>(), TestContract2.Interactor {

    override fun onCreate(extras: Bundle?, savedInstanceState: Bundle?) {
        super.onCreate(extras, savedInstanceState)
        Log.d("VIPER", "Activity2.Interactor.onCreate")
    }
}