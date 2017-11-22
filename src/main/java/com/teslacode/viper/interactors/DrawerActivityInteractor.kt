package com.teslacode.viper.interactors

import com.teslacode.viper.contracts.DrawerActivityContract.Interactor
import com.teslacode.viper.contracts.DrawerActivityContract.InteractorOutput

/**
 * Created by adefruandta on 10/6/17.
 */

open class DrawerActivityInteractor<T : InteractorOutput> : ActivityInteractor<T>(), Interactor
