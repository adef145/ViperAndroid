package com.teslacode.viper.interactors

import com.teslacode.viper.contracts.ViperDrawerActivityContract.Interactor
import com.teslacode.viper.contracts.ViperDrawerActivityContract.InteractorOutput

/**
 * Created by adefruandta on 10/6/17.
 */

open class ViperDrawerActivityInteractor<T : InteractorOutput> : ViperActivityInteractor<T>(), Interactor
