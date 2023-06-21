package com.starter.app.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.starter.app.di.ViewModelKey
import com.starter.app.pagination.QuoteViewModel
import com.starter.app.ui.auth.viewmodel.LoginViewModel
import com.starter.app.ui.base.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(QuoteViewModel::class)
    abstract fun bindQuoteViewModel(quoteViewModel: QuoteViewModel): ViewModel

}