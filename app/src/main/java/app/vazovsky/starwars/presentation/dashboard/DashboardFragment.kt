package app.vazovsky.starwars.presentation.dashboard

import android.os.Bundle
import androidx.fragment.app.viewModels
import app.vazovsky.starwars.R
import app.vazovsky.starwars.databinding.FragmentDashboardBinding
import app.vazovsky.starwars.extensions.fitTopInsetsWithPadding
import app.vazovsky.starwars.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment(R.layout.fragment_dashboard) {

    private val binding by viewBinding(FragmentDashboardBinding::bind)
    private val viewModel: DashboardViewModel by viewModels()

    override fun callOperations() {

    }

    override fun onSetupLayout(savedInstanceState: Bundle?) = with(binding) {
        root.fitTopInsetsWithPadding()
    }

    override fun onBindViewModel() = with(viewModel) {
        observeNavigationCommands()
    }
}