package app.vazovsky.starwars.presentation.characters

import android.os.Bundle
import androidx.fragment.app.viewModels
import app.vazovsky.starwars.R
import app.vazovsky.starwars.databinding.FragmentCharactersBinding
import app.vazovsky.starwars.extensions.fitTopInsetsWithPadding
import app.vazovsky.starwars.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : BaseFragment(R.layout.fragment_characters) {

    private val binding by viewBinding(FragmentCharactersBinding::bind)
    private val viewModel: CharactersViewModel by viewModels()

    override fun callOperations() {

    }

    override fun onSetupLayout(savedInstanceState: Bundle?) = with(binding) {
        root.fitTopInsetsWithPadding()
    }

    override fun onBindViewModel() = with(viewModel) {
        observeNavigationCommands()
    }
}