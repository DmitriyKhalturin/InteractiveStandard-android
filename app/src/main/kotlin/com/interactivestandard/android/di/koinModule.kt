package com.interactivestandard.android.di

import com.interactivestandard.android.ui.screen.main.MainViewModel
import com.interactivestandard.data.api.ApiClient
import com.interactivestandard.data.repository.PointsRepositoryImpl
import com.interactivestandard.domain.repository.PointsRepository
import com.interactivestandard.domain.usecase.GetPointsUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 20.01.2023 18:56.
 */

val koinModule by lazy {
    module {
        viewModelOf(::MainViewModel)
        singleOf(::ApiClient)
        factoryOf(::PointsRepositoryImpl) { bind<PointsRepository>() }
        factoryOf(::GetPointsUseCase)
    }
}
