package com.pantos27.stockexplorer.ui.bankdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pantos27.stockexplorer.R
import com.pantos27.stockexplorer.data.dto.Bank
import com.pantos27.stockexplorer.data.dto.TimeData
import com.pantos27.stockexplorer.data.dto.TimeItemModel
import com.pantos27.stockexplorer.databinding.BankItemBinding
import com.pantos27.stockexplorer.databinding.TimeDataItemBinding

class TimeDataAdapter: ListAdapter<TimeItemModel,TimeItemViewHolder>(TimeItemDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeItemViewHolder {
        val binding: TimeDataItemBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.time_data_item, parent, false)
        return TimeItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TimeItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}

class TimeItemViewHolder(private val binding: TimeDataItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(data: TimeItemModel) {
        binding.item = data
    }
}

object TimeItemDiffUtil: DiffUtil.ItemCallback<TimeItemModel>(){
    override fun areItemsTheSame(oldItem: TimeItemModel, newItem: TimeItemModel): Boolean {
        return oldItem.time == newItem.time
    }

    override fun areContentsTheSame(oldItem: TimeItemModel, newItem: TimeItemModel): Boolean {
        return oldItem == newItem
    }
}