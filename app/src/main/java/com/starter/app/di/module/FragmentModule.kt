package com.starter.app.di.module

import com.starter.app.di.PerFragment
import com.starter.app.ui.base.BaseFragment
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val baseFragment: BaseFragment<*>) {

    @Provides
    @PerFragment
    internal fun provideBaseFragment(): BaseFragment<*> {
        return baseFragment
    }

}
