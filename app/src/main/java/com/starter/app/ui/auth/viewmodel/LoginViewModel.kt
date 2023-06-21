package com.starter.app.ui.auth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.a14_6_23_pagination.pagination.paging.model.QuoteList
import com.starter.app.data.pojo.User
import com.starter.app.data.pojo.request.LoginRequest
import com.starter.app.data.repository.UserRepository
import com.starter.app.ui.base.APILiveData
import com.starter.app.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val userRepository: UserRepository) :
    BaseViewModel() {

    val loginLiveData = APILiveData<User>()

    fun login(request: LoginRequest) {
        viewModelScope.launch {
            val result = userRepository.login(request)
            loginLiveData.value = result
        }
    }

}