package com.daviabrantes.hearthstone.presentation

import com.daviabrantes.hearthstone.viewmodel.CardViewModel
import io.mockk.coEvery
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Test

class HearthstoneViewModelTest {

    private lateinit var viewModel: CardViewModel

    @After
    fun tearDown() {
        HearthstoneViewModelRobot.tearDown()
    }

    @Test
    fun `when start viewModel should execute getCards`() {
        HearthstoneViewModelRobot.apply {
            arrange {
                mockSuccess()
            }

            act {
                initViewModel()
            }

            assert {
                isGetCards()
            }
        }
    }

    @Test(expected = RuntimeException::class)
    fun `should throw an exception when the calling to getAllCards returns exception`() = runBlocking {

            coEvery { viewModel.getCards("") } throws Exception()

            val result = viewModel.getCards("")
        }
}