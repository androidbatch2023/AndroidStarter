package com.starter.app.pagination

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.a14_6_23_pagination.pagination.paging.model.Result
import com.starter.app.databinding.ItemQuotedataBinding

class PagingAdapter :
    PagingDataAdapter<com.example.a14_6_23_pagination.pagination.paging.model.Result, PagingAdapter.PagingViewHolder>(
        COMPARATOR
    ) {

    inner class PagingViewHolder(var binding: ItemQuotedataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val quote = binding.quote

    }


    companion object {
        private val COMPARATOR = object :
            DiffUtil.ItemCallback<com.example.a14_6_23_pagination.pagination.paging.model.Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {

        val item = getItem(position)
        if (item != null) {
            holder.quote.text = item.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        return PagingViewHolder(
            ItemQuotedataBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}