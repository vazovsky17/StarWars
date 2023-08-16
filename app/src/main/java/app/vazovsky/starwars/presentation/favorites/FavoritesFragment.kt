package app.vazovsky.starwars.presentation.favorites

import android.os.Bundle
import androidx.fragment.app.viewModels
import app.vazovsky.starwars.R
import app.vazovsky.starwars.databinding.FragmentFavoritesBinding
import app.vazovsky.starwars.extensions.fitTopInsetsWithPadding
import app.vazovsky.starwars.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : BaseFragment(R.layout.fragment_favorites) {

    private val binding by viewBinding(FragmentFavoritesBinding::bind)
    private val viewModel: FavoritesViewModel by viewModels()

    override fun callOperations() {

    }

    override fun onSetupLayout(savedInstanceState: Bundle?) = with(binding) {
        root.fitTopInsetsWithPadding()
    }

    override fun onBindViewModel() = with(viewModel) {
        observeNavigationCommands()
    }
}