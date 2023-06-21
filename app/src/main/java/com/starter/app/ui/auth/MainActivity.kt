package com.starter.app.ui.auth

import android.os.Bundle
import android.view.View
import com.starter.app.R
import com.starter.app.databinding.ActivityMainBinding
import com.starter.app.di.component.ActivityComponent
import com.starter.app.pagination.PagingFragment
import com.starter.app.ui.base.BaseActivity
import dagger.internal.DaggerGenerated

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun findFragmentPlaceHolder(): Int {
        return R.id.fragment
    }

    override fun createViewBinding(): View {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        load(PagingFragment::class.java).add(true)
    }
}