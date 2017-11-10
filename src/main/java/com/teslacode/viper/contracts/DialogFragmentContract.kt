package com.teslacode.viper.contracts

import android.app.Dialog
import android.os.Bundle

/**
 * Created by adefruandta on 8/16/17.
 */

interface DialogFragmentContract {

    interface ViewBehavior : FragmentContract.ViewBehavior {

        fun hide()
    }

    interface Presenter : FragmentContract.Presenter {

        fun onCreateDialog(): Dialog?
    }

    interface Interactor : FragmentContract.Interactor

    interface InteractorOutput : FragmentContract.InteractorOutput {

        fun hide()
    }
}
