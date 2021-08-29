package com.pantos27.stockexplorer.ui.bankdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.pantos27.stockexplorer.R
import com.pantos27.stockexplorer.data.dto.Bank
import com.pantos27.stockexplorer.databinding.BankDetailsFragmentBinding
import com.pantos27.stockexplorer.ui.base.BaseFragment

class BankDetailsFragment: BaseFragment() {

    private val viewModel by viewModels<BankDetailsViewModel>()
    private lateinit var binding : BankDetailsFragmentBinding
    private val args: BankDetailsFragmentArgs by navArgs()
    private lateinit var bank: Bank
    private val adapter = TimeDataAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.bank_details_fragment, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToErrors(viewModel,true)
        viewModel.navController = findNavController()
        bank = args.bank
        binding.bank = bank

        viewModel.bankData.observe(viewLifecycleOwner,{
            binding.timeData = it
            binding.detailRecycler.adapter = adapter
            adapter.submitList(it.timeItems)
        })
        viewModel.getBankData(bank)
    }

}