package com.starter.app.ui.auth

import android.os.Bundle
import android.view.View
import com.starter.app.R
import com.starter.app.databinding.IsolatedAcitivtyFullBinding
import com.starter.app.di.component.ActivityComponent
import com.starter.app.ui.base.BaseActivity
import com.starter.app.ui.base.BaseFragment
import com.starter.app.ui.manager.ActivityStarter

class IsolatedFullActivity : BaseActivity() {

    lateinit var isolatedFullActivityBinding: IsolatedAcitivtyFullBinding

    override fun findFragmentPlaceHolder(): Int {
        return R.id.placeHolder
    }

    override fun createViewBinding(): View {
        isolatedFullActivityBinding=IsolatedAcitivtyFullBinding.inflate(layoutInflater)
        return isolatedFullActivityBinding.root
    }


    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {

            val page = intent.getSerializableExtra(ActivityStarter.ACTIVITY_FIRST_PAGE) as Class<BaseFragment<*>>
            load(page)
                    .setBundle(intent.extras!!)
                    .replace(false)
        }

    }
}