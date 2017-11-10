package com.teslacode.viper.activities

import com.teslacode.viper.R
import com.teslacode.viper.contracts.ToolbarExtendedActivityContract.Presenter
import com.teslacode.viper.fragments.BaseFragment

/**
 * Created by adefruandta on 10/23/17.
 */

class ToolbarExtendedActivity<F : BaseFragment<*>, P : Presenter> : BaseActivity<F, P>() {

    override var layoutResId: Int = R.layout.activity_toolbar_extended
}
