package com.teslacode.viper.interactors

import com.teslacode.viper.contracts.ViperDialogFragmentContract.Interactor
import com.teslacode.viper.contracts.ViperDialogFragmentContract.InteractorOutput

/**
 * Created by adefruandta on 8/16/17.
 */

open class ViperDialogFragmentInteractor<T : InteractorOutput> : ViperFragmentInteractor<T>(), Interactor
