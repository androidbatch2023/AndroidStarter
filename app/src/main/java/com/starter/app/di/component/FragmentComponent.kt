package com.starter.app.di.component

import com.starter.app.di.PerFragment
import com.starter.app.di.module.FragmentModule
import com.starter.app.pagination.PagingFragment
import com.starter.app.ui.auth.fragment.LoginFragment
import com.starter.app.ui.auth.fragment.SignupFragment
import com.starter.app.ui.base.BaseFragment
import com.starter.app.ui.home.fragment.MainFragment
import com.starter.app.ui.home.fragment.OrderFragment
import dagger.Subcomponent

@PerFragment
@Subcomponent(modules = [(FragmentModule::class)])
interface FragmentComponent {
    fun baseFragment(): BaseFragment<*>
    fun inject(loginFragment: LoginFragment)
    fun inject(loginFragment: SignupFragment)
    fun inject(mainFragment: MainFragment)
    fun inject(orderFragment: OrderFragment)
    fun inject(pagingFragment: PagingFragment)

}
