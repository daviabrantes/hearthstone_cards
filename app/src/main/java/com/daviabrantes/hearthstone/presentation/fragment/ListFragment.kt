package com.daviabrantes.hearthstone.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.daviabrantes.hearthstone.R
import com.daviabrantes.hearthstone.databinding.FragmentListBinding
import com.daviabrantes.hearthstone.databinding.FragmentListBinding.*
import com.daviabrantes.hearthstone.presentation.adapter.CardListGridRecyclerAdapter
import com.daviabrantes.hearthstone.util.NetworkResult
import com.daviabrantes.hearthstone.viewmodel.CardViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val args by navArgs<ListFragmentArgs>()

    private val cardViewModel by viewModel<CardViewModel>()
    private val cardListAdapter = CardListGridRecyclerAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = inflate(inflater, container, false)
        backButtonListener()
        initView()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cardViewModel.getCards(args.filterParameters)

        collectState()

    }

    private fun collectState() {
        lifecycleScope.launchWhenCreated {
            cardViewModel.cardsResponse.collect { state ->
                when (state) {
                    is NetworkResult.Loading -> {
                        binding.progressBarList.visibility = View.VISIBLE
                    }
                    is NetworkResult.Success -> {
                        binding.progressBarList.visibility = View.GONE
                        state.cardVO?.let { cardListAdapter.setCardsData(it) }
                    }
                    is NetworkResult.Error -> {
                        binding.progressBarList.visibility = View.GONE
                        setErrorState()
                    }
                }
            }
        }
    }

    private fun setErrorState() {
        Toast.makeText(context, getString(R.string.service_error), Toast.LENGTH_LONG)
            .show()
    }

    private fun initView() {
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.adapter = cardListAdapter
        binding.textFilter.text = args.filterName
    }

    private fun backButtonListener() {
        binding.buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}