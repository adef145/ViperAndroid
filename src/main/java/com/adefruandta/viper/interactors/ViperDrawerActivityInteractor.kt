package com.adefruandta.viper.interactors

import com.adefruandta.viper.contracts.ViperDrawerActivityContract.Interactor
import com.adefruandta.viper.contracts.ViperDrawerActivityContract.InteractorOutput

/**
 * Created by adefruandta on 10/6/17.
 */

open class ViperDrawerActivityInteractor<T : InteractorOutput> : ViperActivityInteractor<T>(), Interactor
