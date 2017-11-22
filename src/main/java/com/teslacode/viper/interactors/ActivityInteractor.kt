package com.teslacode.viper.interactors

import android.content.Intent
import android.os.Bundle
import com.teslacode.viper.contracts.ActivityContract.Interactor
import com.teslacode.viper.contracts.ActivityContract.InteractorOutput

/**
 * Created by adefruandta on 8/13/17.
 */

open class ActivityInteractor<T : InteractorOutput> : BaseInteractor<T>(), Interactor {


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

    override fun savedInstanceState(outState: Bundle?) {

    }

    // endregion
}
