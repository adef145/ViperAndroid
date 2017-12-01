package com.adefruandta.viper.interactors

import com.adefruandta.viper.contracts.ViperDialogFragmentContract.Interactor
import com.adefruandta.viper.contracts.ViperDialogFragmentContract.InteractorOutput

/**
 * Created by adefruandta on 8/16/17.
 */

open class ViperDialogFragmentInteractor<T : InteractorOutput> : ViperFragmentInteractor<T>(), Interactor
