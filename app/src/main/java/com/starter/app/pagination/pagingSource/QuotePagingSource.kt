package com.starter.app.pagination.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.a14_6_23_pagination.pagination.paging.model.Result
import com.starter.app.pagination.model.QuoteApi

class QuotePagingSource(val quoteApi: QuoteApi) :
    PagingSource<Int, Result>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val position = params.key ?: 1
            val response = quoteApi.getQuotes(position)

            return LoadResult.Page(
                response.results,
                if (position == 1) null else position - 1,//pre page
                if (position == response.totalPages) null else position + 1
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }
}