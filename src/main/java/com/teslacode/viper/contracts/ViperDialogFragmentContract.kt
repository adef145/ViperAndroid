package com.teslacode.viper.contracts

import android.app.Dialog

/**
 * Created by adefruandta on 8/16/17.
 */

interface ViperDialogFragmentContract {

    interface ViewBehavior : ViperFragmentContract.ViewBehavior {

        fun dismiss()
    }

    interface Presenter : ViperFragmentContract.Presenter {

        fun onCreateDialog(): Dialog?
    }

    interface Interactor : ViperFragmentContract.Interactor

    interface InteractorOutput : ViperFragmentContract.InteractorOutput {

        fun dismiss()
    }
}
