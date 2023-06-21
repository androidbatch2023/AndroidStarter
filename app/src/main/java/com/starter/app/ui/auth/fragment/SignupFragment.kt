package com.starter.app.ui.auth.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.starter.app.databinding.AuthFragmentSignupBinding
import com.starter.app.di.component.FragmentComponent
import com.starter.app.ui.base.BaseFragment

/**
 * Base Fragment has T type class, pass viewbinding name on this T type,
 */
class SignupFragment: BaseFragment<AuthFragmentSignupBinding>() {

    /**
     * Inject fragmentComponent for dagger
     */
    override fun inject(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    /**
     * Create view binding object and return this object for set layout on fragment.
     */
    override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): AuthFragmentSignupBinding {
        return AuthFragmentSignupBinding.inflate(inflater,container,attachToRoot)
    }

    /**
     * This method is call when on onViewCreated call from life cycle
     * THis one is used for bind data to control
     */
    override fun bindData() {

    }
}