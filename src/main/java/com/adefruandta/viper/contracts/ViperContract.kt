package com.adefruandta.viper.contracts

import android.content.Intent
import android.os.Bundle

/**
 * Created by adefruandta on 8/7/17.
 */

interface ViperContract {

    interface ViewBehavior

    interface Presenter {

        fun unregister()
    }

    interface Interactor {

        fun setInteractorOutput(output: InteractorOutput)

        fun unregister()
    }

    interface InteractorOutput

    interface Router {

        fun startActivity(intent: Intent)

        fun startActivity(intent: Intent, options: Bundle?)

        fun startActivityForResult(intent: Intent, requestCode: Int)

        fun unregister()
    }
}
