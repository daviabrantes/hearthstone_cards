package com.daviabrantes.hearthstone.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daviabrantes.hearthstone.R
import com.daviabrantes.hearthstone.databinding.ListItemGridCardBinding
import com.daviabrantes.hearthstone.presentation.fragment.ListFragmentDirections
import com.daviabrantes.hearthstone.presentation.model.CardVO

class CardListGridRecyclerAdapter(parentFragment : Fragment) : RecyclerView.Adapter<CardListGridRecyclerAdapter.CardListViewHolder>() {

    private var parentFragment = parentFragment
    private var cardList = listOf<CardVO>()

    class CardListViewHolder(private val binding: ListItemGridCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindView(cardModel: CardVO) {

            Glide.with(itemView)  //2
                .load(cardModel.img) //3
                .override(450,300)
                .placeholder(R.drawable.img_card)
                .fallback(R.drawable.ic_broken_image)
                .into(binding.cardImage) //8
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardListViewHolder {
        return CardListViewHolder(
            ListItemGridCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CardListViewHolder, position: Int) {
        holder.bindView(cardList[position])
        val cardPosition = cardList[position]
        holder.itemView.setOnClickListener {
            findNavController(parentFragment).navigate(
            ListFragmentDirections.actionListFragmentToDetailsFragment(cardPosition.cardId))
        }
    }

    override fun getItemCount(): Int = cardList.size

    fun setCardsData(listOfCards: List<CardVO>) {
        cardList = listOfCards
        notifyDataSetChanged()
    }
}
