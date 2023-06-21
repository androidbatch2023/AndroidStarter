package com.starter.app.di.module

import com.starter.app.data.datasource.UserLiveDataSource
import com.starter.app.data.repository.UserRepository
import com.starter.app.data.service.AuthenticationService
import com.starter.app.pagination.model.QuoteApi
import com.starter.app.pagination.repository.QuoteRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideUserRepository(userLiveDataSource: UserLiveDataSource): UserRepository {
        return userLiveDataSource
    }

    @Provides
    @Singleton
    fun provideAuthenticationService(retrofit: Retrofit): AuthenticationService {
        return retrofit.create(AuthenticationService::class.java)
    }

   

    @Provides
    @Singleton
    fun quoteApi(retrofit: Retrofit): QuoteApi {
        return retrofit.create(QuoteApi::class.java)
    }

}