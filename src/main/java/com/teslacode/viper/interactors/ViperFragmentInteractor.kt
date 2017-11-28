package com.teslacode.viper.interactors

import android.content.Intent
import android.os.Bundle
import com.teslacode.viper.contracts.ViperFragmentContract

/**
 * Created by adefruandta on 8/8/17.
 */

open class ViperFragmentInteractor<T : ViperFragmentContract.InteractorOutput> : ViperInteractor<T>(), ViperFragmentContract.Interactor {

    // region Interactor

    override fun onCreate(extras: Bundle?, savedInstanceState: Bundle?) {

    }

    override fun onViewCreated() {

    }

    override fun onStart() {

    }

    override fun onResume() {

    }

    override fun onStop() {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

    }

    override fun onSavedInstanceState(outState: Bundle?) {

    }

    // endregion
}
