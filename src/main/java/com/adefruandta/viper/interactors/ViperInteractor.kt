package com.adefruandta.viper.interactors

import com.adefruandta.viper.contracts.ViperContract.Interactor
import com.adefruandta.viper.contracts.ViperContract.InteractorOutput

/**
 * Created by adefruandta on 8/3/17.
 */

open class ViperInteractor<O : InteractorOutput> : Interactor {

    // region Attributes

    protected var output: O? = null

    // endregion

    // region Interactor

    @Suppress("UNCHECKED_CAST")
    override fun setInteractorOutput(output: InteractorOutput) {
        this.output = output as O
    }

    override fun unregister() {
        output = null
    }

    // endregion
}
