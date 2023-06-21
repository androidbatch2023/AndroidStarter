package com.starter.app.ui.home.fragment

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.starter.app.databinding.HomeFragmentMainBinding
import com.starter.app.di.component.FragmentComponent
import com.starter.app.ui.auth.IsolatedFullActivity
import com.starter.app.ui.base.BaseFragment

class MainFragment : BaseFragment<HomeFragmentMainBinding>() {

    private var startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback { activityResult ->
            if (activityResult.resultCode == Activity.RESULT_OK) {
                activityResult.data?.let {
                    showMessage(it.getStringExtra("my_data")?:"")
                }
            } else if (activityResult.resultCode == Activity.RESULT_CANCELED) {
                //cancelled
            }
        })

    override fun inject(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean,
    ): HomeFragmentMainBinding {
        return HomeFragmentMainBinding.inflate(inflater, container, attachToRoot)
    }

    override fun bindData() {
        binding.buttonStart.setOnClickListener {
            navigator.loadActivity(IsolatedFullActivity::class.java, OrderFragment::class.java)
                .forResult(startForResult)
                .start()
        }
    }
}