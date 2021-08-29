package com.pantos27.stockexplorer.ui.base

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.pantos27.stockexplorer.R

abstract class BaseFragment : Fragment() {

    fun subscribeToErrors(viewModel: BaseViewModel,shouldGoBack: Boolean = false) {
        viewModel.error.observe(viewLifecycleOwner, {
            AlertDialog.Builder(requireContext())
                .setTitle(R.string.error_message)
                .setMessage(it.message)
                .setIcon(android.R.drawable.stat_notify_error)
                .setNeutralButton(android.R.string.ok) { _, _ ->
                    if (shouldGoBack) viewModel.navController.navigateUp()
                }
                .show()
        })
    }
}