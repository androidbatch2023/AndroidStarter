package com.starter.app.data.service

import com.example.a14_6_23_pagination.pagination.paging.model.QuoteList
import com.starter.app.data.URLFactory
import com.starter.app.data.pojo.ResponseBody
import com.starter.app.data.pojo.User
import com.starter.app.data.pojo.request.LoginRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthenticationService {

    /**
     * API calling url and method
     */
    @POST(URLFactory.Method.LOGIN)
    suspend fun login(@Body request: LoginRequest): ResponseBody<User>



}