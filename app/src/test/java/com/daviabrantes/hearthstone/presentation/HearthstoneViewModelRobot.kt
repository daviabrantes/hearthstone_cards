package com.daviabrantes.hearthstone.presentation

import com.daviabrantes.hearthstone.domain.model.CardDummy
import com.daviabrantes.hearthstone.domain.usecase.CardUseCase
import com.daviabrantes.hearthstone.viewmodel.CardViewModel
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.flow.flow
import org.junit.Assert

object HearthstoneViewModelRobot {

    private lateinit var viewModel: CardViewModel
    private val getCardsUseCase = mockk<CardUseCase>(relaxed = true)

    fun tearDown() {
        unmockkAll()
        clearAllMocks()
    }

    infix fun arrange(func: HearthstoneFragmentArrange.() -> Unit) =
        HearthstoneFragmentArrange().apply(func)

    infix fun act(func: HearthstoneFragmentAct.() -> Unit) =
        HearthstoneFragmentAct().apply(func)

    infix fun assert(func: HearthstoneFragmentAssert.() -> Unit) =
        HearthstoneFragmentAssert().apply(func)


    class HearthstoneFragmentArrange {
        fun mockSuccess() {
            every { getCardsUseCase.getCards("") } returns
                    flow { emit(CardDummy.getListCard()) }
        }
    }

    class HearthstoneFragmentAct {
        fun initViewModel() {
            viewModel = CardViewModel(getCardsUseCase)
        }
    }

    class HearthstoneFragmentAssert {

        fun isGetCards() {
            Assert.assertNotNull(viewModel.cardsResponse.value)
        }
    }
}
