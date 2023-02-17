package com.daviabrantes.hearthstone.domain

import com.daviabrantes.hearthstone.data.repository.CardRepository
import com.daviabrantes.hearthstone.domain.model.CardDummy
import com.daviabrantes.hearthstone.domain.usecase.CardUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class CardUseCaseTest {

    private lateinit var getAllCardsUseCase: CardUseCase

    private val repository = mockk<CardRepository>()

    @Before
    fun setup() {
        getAllCardsUseCase = CardUseCase(repository)
    }

    @Test
    fun `when getAllCards return success with a card list`() = runBlocking {

        //GIVEN
        coEvery { repository.getCards("") } returns
                CardDummy.getListCard()

        //WHEN
        val result = getAllCardsUseCase.getCards("")

        //THEN
        assertNotNull(result.single())
    }

    @Test(expected = Exception::class)
    fun `getAllCards throws generic exception`() = runBlocking {

        //GIVEN
        coEvery { repository.getCards("") } throws Exception()

        //WHEN
        val result = repository.getCards("")
    }
}