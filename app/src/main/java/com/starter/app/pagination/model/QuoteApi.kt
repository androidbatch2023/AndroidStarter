package com.starter.app.pagination.model

import com.example.a14_6_23_pagination.pagination.paging.model.QuoteList
import com.starter.app.data.URLFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {

    @GET(URLFactory.Method.PAGE_LOAD)
    suspend fun getQuotes(@Query("page") page: Int): QuoteList

}