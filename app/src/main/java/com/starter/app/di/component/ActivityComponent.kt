package com.starter.app.di.component

import com.starter.app.ui.home.HomeActivity
import com.starter.app.di.PerActivity
import com.starter.app.di.module.ActivityModule
import com.starter.app.di.module.FragmentModule
import com.starter.app.ui.auth.AuthActivity
import com.starter.app.ui.auth.IsolatedFullActivity
import com.starter.app.ui.auth.MainActivity
import com.starter.app.ui.base.BaseActivity
import com.starter.app.ui.manager.Navigator
import com.starter.app.ui.splash.SplashActivity

import dagger.BindsInstance
import dagger.Component

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun activity(): BaseActivity

    fun navigator(): Navigator


    operator fun plus(fragmentModule: FragmentModule): FragmentComponent

    fun inject(mainActivity: HomeActivity)
    fun inject(mainActivity: SplashActivity)
    fun inject(authActivity: AuthActivity)
    fun inject(isolatedFullActivity: IsolatedFullActivity)
    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {

        fun bindApplicationComponent(applicationComponent: ApplicationComponent): Builder

        @BindsInstance
        fun bindActivity(baseActivity: BaseActivity): Builder

        fun build(): ActivityComponent
    }
}
