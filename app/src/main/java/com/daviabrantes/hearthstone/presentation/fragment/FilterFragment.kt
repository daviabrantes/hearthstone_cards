package com.daviabrantes.hearthstone.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.daviabrantes.hearthstone.databinding.FragmentFilterBinding
import com.daviabrantes.hearthstone.util.Filter

class FilterFragment : Fragment() {

    private lateinit var binding: FragmentFilterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilterBinding.inflate(inflater, container, false)
        setupObservers()
        return binding.root
    }

    private fun setupObservers() {

        binding.buttonDruid.setOnClickListener {
            navigateToResults(Filter.DRUID)
        }

        binding.buttonHunter.setOnClickListener {
            navigateToResults(Filter.HUNTER)
        }

        binding.buttonWeapon.setOnClickListener {
            navigateToResults(Filter.WEAPON)
        }

        binding.buttonSpell.setOnClickListener {
            navigateToResults(Filter.SPELL)
        }

        binding.buttonCommon.setOnClickListener {
            navigateToResults(Filter.COMMON)
        }

        binding.buttonEpic.setOnClickListener {
            navigateToResults(Filter.EPIC)
        }
    }

    private fun navigateToResults(parameters: Filter) {
        findNavController().navigate(
            FilterFragmentDirections.actionFilterFragmentToListFragment(
                parameters.filterType,
                parameters.filterName
            )
        )
    }
}