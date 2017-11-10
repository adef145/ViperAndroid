package com.teslacode.viper.interactors

import com.teslacode.viper.contracts.BaseContract.Interactor
import com.teslacode.viper.contracts.BaseContract.InteractorOutput

/**
 * Created by adefruandta on 8/3/17.
 */

open class BaseInteractor<T : InteractorOutput> : Interactor {

    // region Attributes

    protected var output: T? = null

    // endregion

    // region Interactor

    @Suppress("UNCHECKED_CAST")
    override fun setInteractorOutput(output: InteractorOutput) {
        this.output = output as T
    }

    override fun unregister() {
        output = null
    }

    // endregion
}
