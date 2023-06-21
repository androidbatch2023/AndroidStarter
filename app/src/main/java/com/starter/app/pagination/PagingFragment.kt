package com.starter.app.pagination

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.starter.app.databinding.FragmentLoadDataBinding
import com.starter.app.di.component.FragmentComponent
import com.starter.app.ui.base.BaseFragment

class PagingFragment : BaseFragment<FragmentLoadDataBinding>() {
    lateinit var adapter: PagingAdapter
    lateinit var quoteViewModel: QuoteViewModel
    override fun inject(fragmentComponent: FragmentComponent) {
        fragmentComponent.inject(this)
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ): FragmentLoadDataBinding {
        return FragmentLoadDataBinding.inflate(inflater, container, false)
    }

    override fun bindData() {

        adapter = PagingAdapter()
        quoteViewModel = requireActivity().run {
            ViewModelProvider(this, viewModelFactory).get(QuoteViewModel::class.java)
        }

        binding.rvQuoteDataShowPaging.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.rvQuoteDataShowPaging.adapter = adapter.withLoadStateFooter(
            footer = LoaderAdapter()
        )
        binding.rvQuoteDataShowPaging.setHasFixedSize(true)

        quoteViewModel.list.observe(this, Observer {
            Log.d("TAG", "bindData() $it")
            adapter.submitData(lifecycle, it)
//            database.getQuoteDao().addData()
        })
    }
}