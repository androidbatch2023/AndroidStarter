package com.starter.app.data.datasource

import com.example.a14_6_23_pagination.pagination.paging.model.QuoteList
import com.starter.app.data.pojo.DataWrapper
import com.starter.app.data.pojo.User
import com.starter.app.data.pojo.request.LoginRequest
import com.starter.app.data.repository.UserRepository
import com.starter.app.data.service.AuthenticationService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserLiveDataSource @Inject constructor(private val authenticationService: AuthenticationService) :
    BaseDataSource(), UserRepository {

    override suspend fun login(request: LoginRequest): DataWrapper<User> {
        return execute { authenticationService.login(request) }
    }
//
//    override suspend fun getQuotes(page: Int): QuoteList {
//        return  authenticationService.getQuotes(page)
//    }

}
