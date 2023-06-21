package com.starter.app.ui.auth.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.starter.app.data.pojo.User
import com.starter.app.data.pojo.request.LoginRequest
import com.starter.app.ui.home.HomeActivity
import com.starter.app.databinding.AuthFragmentLoginBinding
import com.starter.app.di.component.FragmentComponent
import com.starter.app.exception.ApplicationException
import com.starter.app.ui.auth.viewmodel.LoginViewModel
import com.starter.app.ui.base.BaseFragment
import com.starter.app.utils.Validator
import javax.inject.Inject

class LoginFragment : BaseFragment<AuthFragmentLoginBinding>() {

    @Inject
    lateinit var validator: Validator

    private val viewModel by lazy {
        ViewModelProvider(this,
            viewModelFactory)[LoginViewModel::class.java]
    }

    private val data by lazy {
        arguments?.getString("data") ?: ""
    }

    override fun inject(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean,
    ): AuthFragmentLoginBinding {
        return AuthFragmentLoginBinding.inflate(inflater, container, attachToRoot)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeLiveData()
    }

    override fun bindData() {
        Log.e("Data", data)
        binding.buttonLogin.setOnClickListener {
            try {
                validator.submit(binding.editTextEmail).checkEmpty()
                    .errorMessage("Please enter email").checkValidEmail()
                    .errorMessage("Please enter valid email address").check()
                validator.submit(binding.editTextPassword).checkEmpty()
                    .errorMessage("Please enter password").check()
                validator.submit(binding.editTextConfirmPassword).checkEmpty()
                    .errorMessage("Please enter confirm password")
                    .matchString(binding.editTextPassword.text.toString())
                    .errorMessage("Please enter valid password").check()
                if (!binding.checkBoxTC.isChecked) {
                    throw  ApplicationException("Please select checkbox")
                }

                val request = LoginRequest(
                    countryCode = "+1",
                    phone = "1313131313",
                    password = "123456",
                    deviceId = "123",
                    deviceType = "A"
                )
                viewModel.login(request)

            } catch (e: ApplicationException) {
                showMessage(e)
            }

        }
        binding.buttonRegister.setOnClickListener {
            navigator.load(SignupFragment::class.java).replace(true, "Test")
        }
    }

    override fun onBackActionPerform(): Boolean {
        return false
    }

    private fun observeLiveData() {
        viewModel.loginLiveData.observe(this,
            onChange = { responseBody ->
                navigator.loadActivity(HomeActivity::class.java).byFinishingCurrent().start()
            }, onError = { throwable: Throwable ->
                true
            })
    }
}