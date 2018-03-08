package com.adefruandta.viperandroid.fragment

import android.os.Bundle
import android.util.Log
import com.adefruandta.viper.interactors.ViperInteractor
import com.adefruandta.viperandroid.fragment.TestContract.Interactor
import com.adefruandta.viperandroid.fragment.TestContract.InteractorOutput

/**
 * Created by adefruandta on 12/15/17.
 */
class TestInteractor : ViperInteractor<InteractorOutput>(), Interactor {

    override fun onCreate(extras: Bundle?, savedInstanceState: Bundle?) {
        super.onCreate(extras, savedInstanceState)
        Log.d("VIPER", "Fragment.Interactor.onCreate")
    }
}