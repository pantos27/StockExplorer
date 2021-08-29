package com.pantos27.stockexplorer.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pantos27.stockexplorer.R
import com.pantos27.stockexplorer.databinding.MainFragmentBinding
import com.pantos27.stockexplorer.ui.base.BaseFragment

class MainFragment : BaseFragment() {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToErrors(viewModel)
        viewModel.navController = findNavController()
        val adapter = BanksAdapter(viewModel)
        binding.mainRecyclerBanks.adapter = adapter

        viewModel.banks.observe(viewLifecycleOwner, { banks ->
            adapter.submitList(banks)
        })
        viewModel.getData(requireContext().assets)
    }

}