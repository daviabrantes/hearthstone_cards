package com.daviabrantes.hearthstone.domain

import com.daviabrantes.hearthstone.data.model.CardResponseDummy
import com.daviabrantes.hearthstone.data.remote.HearthstoneApi
import com.daviabrantes.hearthstone.data.repository.CardRepository
import com.daviabrantes.hearthstone.domain.model.CardDummy
import com.daviabrantes.hearthstone.domain.repository.ICardRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import junit.framework.TestCase.assertNotSame
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class RepositoryTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    class ClassicCardsRepositoryTest {

        @RelaxedMockK
        lateinit var repository: ICardRepository

        @MockK
        lateinit var service: HearthstoneApi

        @Before
        fun setUp() {
            MockKAnnotations.init(this)
            repository = CardRepository(service)
        }

        @Test
        fun `GIVEN valid response WHEN called getCards THEN return the default object`() =
            runTest {
                coEvery { service.getCards("") } returns emptyList()
                val expected = CardDummy.getListCard()
                val result = repository.getCards("")
                assertNotSame(expected, result)
            }

        @Test
        fun `GIVEN successful request WHEN called getAllCards THEN differentiate the objects`() = runTest {
            coEvery { service.getCards("TB_BaconShop_HERO_74") } returns CardResponseDummy.getListCardResponseDummy()
            val expected = listOf(CardDummy.getListCard())
            val result = repository.getCards("TB_BaconShop_HERO_74")
            assertNotSame(expected, result)
        }
    }
}