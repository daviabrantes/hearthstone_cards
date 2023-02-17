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
import com.bumptech.glide.Glide
import com.daviabrantes.hearthstone.R
import com.daviabrantes.hearthstone.databinding.FragmentDetailsBinding
import com.daviabrantes.hearthstone.presentation.model.CardVO
import com.daviabrantes.hearthstone.util.NetworkResult
import com.daviabrantes.hearthstone.viewmodel.CardViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment() {

    private val args by navArgs<DetailsFragmentArgs>()

    private lateinit var binding: FragmentDetailsBinding
    private val cardViewModel by viewModel<CardViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        backButtonListener()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cardViewModel.getCards(args.cardId)
        collectState()
    }

    private fun collectState() {
        lifecycleScope.launchWhenCreated {
            cardViewModel.cardsResponse.collect { state ->
                when (state) {
                    is NetworkResult.Loading -> {
                        binding.constraintScreenInfo.alpha = 0.4f
                        binding.progressBarDetails.visibility = View.VISIBLE
                    }
                    is NetworkResult.Success -> {
                        binding.constraintScreenInfo.alpha = 1f
                        binding.progressBarDetails.visibility = View.GONE
                        setCardData(state.cardVO[0])
                    }
                    is NetworkResult.Error -> {
                        binding.constraintScreenInfo.alpha = 1f
                        binding.progressBarDetails.visibility = View.GONE
                        setErrorState()
                    }
                }
            }
        }
    }

    private fun setCardData(cardData: CardVO) {
        binding.textName.text = cardData.name
        binding.textFlavor.text = cardData.flavor
        binding.textSet.text = cardData.cardSet
        binding.textType.text = cardData.type
        binding.textFaction.text = cardData.faction
        binding.textRarity.text = cardData.rarity
        binding.textAttack.text = cardData.attack.toString()
        binding.textHealth.text = cardData.health.toString()
        binding.textCost.text = cardData.cost.toString()

        Glide.with(this)  //2
            .load(cardData.img) //3
            .fitCenter()
            .placeholder(R.drawable.img_card)
            .fallback(R.drawable.ic_broken_image)
            .into(binding.cardImage) //8
    }

    private fun setErrorState() {
        Toast.makeText(context, getString(R.string.service_error), Toast.LENGTH_LONG)
            .show()
    }

    private fun backButtonListener() {
        binding.buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}