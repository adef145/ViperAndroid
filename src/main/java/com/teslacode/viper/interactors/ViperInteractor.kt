package com.teslacode.viper.interactors

import com.teslacode.viper.contracts.Contract.Interactor
import com.teslacode.viper.contracts.Contract.InteractorOutput

/**
 * Created by adefruandta on 8/3/17.
 */

open class ViperInteractor<T : InteractorOutput> : Interactor {

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
