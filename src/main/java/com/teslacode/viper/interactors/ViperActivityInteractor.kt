package com.teslacode.viper.interactors

import android.content.Intent
import android.os.Bundle
import com.teslacode.viper.contracts.ViperActivityContract.Interactor
import com.teslacode.viper.contracts.ViperActivityContract.InteractorOutput

/**
 * Created by adefruandta on 8/13/17.
 */

open class ViperActivityInteractor<T : InteractorOutput> : ViperInteractor<T>(), Interactor {


    // region Interactor

    override fun onCreate(extras: Bundle?, savedInstanceState: Bundle?) {

    }

    override fun onPostCreate() {
        
    }

    override fun onStart() {

    }

    override fun onResume() {

    }

    override fun onStop() {

    }

    override fun onBackPressed() {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

    }

    override fun onSavedInstanceState(outState: Bundle?) {

    }

    // endregion
}
