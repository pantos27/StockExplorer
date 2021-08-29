package com.pantos27.stockexplorer.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pantos27.stockexplorer.R
import com.pantos27.stockexplorer.data.dto.Bank
import com.pantos27.stockexplorer.databinding.BankItemBinding

class BanksAdapter(private val viewModel: MainViewModel) : ListAdapter<Bank,BankViewHolder>(BankDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankViewHolder {
        val binding: BankItemBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.bank_item, parent, false)
        return BankViewHolder(binding,viewModel)
    }

    override fun onBindViewHolder(holder: BankViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}

class BankViewHolder(private val binding: BankItemBinding,private val viewModel: MainViewModel): RecyclerView.ViewHolder(binding.root){
    fun bind(bank: Bank) {
        binding.bank = bank
        binding.root.setOnClickListener{
            viewModel.bankClicked(bank)
        }
    }
}

object BankDiffUtil: DiffUtil.ItemCallback<Bank>(){
    override fun areItemsTheSame(oldItem: Bank, newItem: Bank): Boolean {
        return oldItem.stk == newItem.stk
    }

    override fun areContentsTheSame(oldItem: Bank, newItem: Bank): Boolean {
        return oldItem == newItem
    }
}