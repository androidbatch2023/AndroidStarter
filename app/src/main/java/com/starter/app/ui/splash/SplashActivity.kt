package com.starter.app.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.starter.app.databinding.SplashActivityBinding
import com.starter.app.di.component.ActivityComponent
import com.starter.app.pagination.PagingFragment
import com.starter.app.ui.auth.MainActivity
import com.starter.app.ui.base.BaseActivity

class SplashActivity : BaseActivity() {
    //Data store on after user login
    lateinit var splashActivityBinding: SplashActivityBinding
    override fun findFragmentPlaceHolder(): Int {
        return 0
    }

    override fun createViewBinding(): View {
        splashActivityBinding = SplashActivityBinding.inflate(layoutInflater)
        return splashActivityBinding.root
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
//
//            loadActivity(
//                IsolatedFullActivity::class.java,
//                PagingFragment::class.java
//            ).byFinishingCurrent().start()

            loadActivity(MainActivity::class.java, PagingFragment::class.java).byFinishingCurrent()
                .start()

        }, 2000)
    }

}