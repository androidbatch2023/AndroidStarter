package com.starter.app.ui.auth

import android.os.Bundle
import android.view.View
import com.starter.app.R
import com.starter.app.databinding.AuthAcitivtyBinding
import com.starter.app.di.component.ActivityComponent
import com.starter.app.ui.auth.fragment.LoginFragment
import com.starter.app.ui.base.BaseActivity

class AuthActivity : BaseActivity() {

    /**
     * Declare view binding object
     */
    lateinit var authAcitivtyBinding: AuthAcitivtyBinding

    /**
     * Pass frame layout ID for fragment loading.
     * If you not require fragment loading, then pass 0 in return. eg for this like splash activity
     * Note:- Always used frame layout id "placeHolder"
     */
    override fun findFragmentPlaceHolder(): Int {
        return R.id.placeHolder
    }

    /**
     * Create view binding object and initialize this object to declare view binding.
     * Return view binding root view for set activity layout
     */
    override fun createViewBinding(): View {
        authAcitivtyBinding = AuthAcitivtyBinding.inflate(layoutInflater)
        return authAcitivtyBinding.root
    }

    /**
     * Inject activityComponent for dagger
     */
    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    /**
     * This method is usd for load fragment and read data from bundle etc.
     * Note :- Not call setContentView() on this
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        load(LoginFragment::class.java).replace(false)
    }

}