package com.starter.app.pagination

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.starter.app.pagination.repository.QuoteRepository
import com.starter.app.ui.base.BaseViewModel
import javax.inject.Inject


class QuoteViewModel @Inject constructor(
    var quoteRepository: QuoteRepository
) : BaseViewModel() {

    val list = quoteRepository.getQuotes().cachedIn(viewModelScope)
}