package com.teslacode.viper.interactors

import com.teslacode.viper.contracts.DialogFragmentContract.Interactor
import com.teslacode.viper.contracts.DialogFragmentContract.InteractorOutput

/**
 * Created by adefruandta on 8/16/17.
 */

open class DialogFragmentInteractor<T : InteractorOutput> : FragmentInteractor<T>(), Interactor
