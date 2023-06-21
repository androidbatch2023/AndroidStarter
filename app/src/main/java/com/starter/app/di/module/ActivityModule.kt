package com.starter.app.di.module

import com.starter.app.di.PerActivity
import com.starter.app.ui.base.BaseActivity
import com.starter.app.ui.manager.FragmentHandler
import com.starter.app.ui.manager.Navigator

import javax.inject.Named

import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    @PerActivity
    internal fun navigator(activity: BaseActivity): Navigator {
        return activity
    }

    @Provides
    @PerActivity
    internal fun fragmentManager(baseActivity: BaseActivity): androidx.fragment.app.FragmentManager {
        return baseActivity.supportFragmentManager
    }

    @Provides
    @PerActivity
    @Named("placeholder")
    internal fun placeHolder(baseActivity: BaseActivity): Int {
        return baseActivity.findFragmentPlaceHolder()
    }

    @Provides
    @PerActivity
    internal fun fragmentHandler(fragmentManager: com.starter.app.ui.manager.FragmentManager): FragmentHandler {
        return fragmentManager
    }


}
