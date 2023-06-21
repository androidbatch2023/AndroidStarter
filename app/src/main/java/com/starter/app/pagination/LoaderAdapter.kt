package com.starter.app.pagination

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.starter.app.databinding.ItemLoaderBinding

class LoaderAdapter() : LoadStateAdapter<LoaderAdapter.LoaderViewHolder>() {

    inner class LoaderViewHolder(var binding: ItemLoaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var progressBar = binding.progressBar
        fun bind(loadState: LoadState) {
            progressBar.isVisible = loadState is LoadState.Loading
        }

    }

    override fun onBindViewHolder(holder: LoaderViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoaderViewHolder {
        return LoaderViewHolder(
            ItemLoaderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}