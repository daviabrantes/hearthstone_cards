package com.daviabrantes.hearthstone.di

import com.daviabrantes.hearthstone.data.repository.CardRepository
import com.daviabrantes.hearthstone.domain.repository.ICardRepository
import com.daviabrantes.hearthstone.domain.usecase.CardUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import com.daviabrantes.hearthstone.viewmodel.CardViewModel

val networkModule = module {

    val retrofitSetup = RetrofitSetup()

    single { retrofitSetup.provideOkHttpClient() }
    single { retrofitSetup.provideRetrofit(okHttpClient = get()) }
    factory { retrofitSetup.provideGetService(retrofit = get()) }

    viewModel { CardViewModel(get()) }
    single<ICardRepository> { CardRepository(get()) }
    single { CardUseCase(get()) }
}
