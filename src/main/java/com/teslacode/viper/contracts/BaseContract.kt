package com.teslacode.viper.contracts

import android.content.Intent
import android.os.Bundle
import com.teslacode.viper.interactors.outputs.BaseInteractorOutput
import com.teslacode.viper.viewbehavior.BaseViewBehavior

/**
 * Created by adefruandta on 8/7/17.
 */

interface BaseContract {

    interface ViewBehavior : BaseViewBehavior

    interface Presenter {

        fun unregister()
    }

    interface Interactor {

        fun setInteractorOutput(output: InteractorOutput)

        fun unregister()
    }

    interface InteractorOutput : BaseInteractorOutput

    interface Router {

        fun startActivity(intent: Intent)

        fun startActivity(intent: Intent, options: Bundle?)

        fun startActivityForResult(intent: Intent, requestCode: Int)

        fun unregister()
    }
}
