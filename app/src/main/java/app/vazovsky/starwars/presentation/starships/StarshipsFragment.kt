package app.vazovsky.starwars.presentation.starships

import android.os.Bundle
import androidx.fragment.app.viewModels
import app.vazovsky.starwars.R
import app.vazovsky.starwars.databinding.FragmentStarshipsBinding
import app.vazovsky.starwars.extensions.fitTopInsetsWithPadding
import app.vazovsky.starwars.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StarshipsFragment : BaseFragment(R.layout.fragment_starships) {

    private val binding by viewBinding(FragmentStarshipsBinding::bind)
    private val viewModel: StarshipsViewModel by viewModels()

    override fun callOperations() {

    }

    override fun onSetupLayout(savedInstanceState: Bundle?) = with(binding) {
        root.fitTopInsetsWithPadding()
    }

    override fun onBindViewModel() = with(viewModel) {
        observeNavigationCommands()
    }
}