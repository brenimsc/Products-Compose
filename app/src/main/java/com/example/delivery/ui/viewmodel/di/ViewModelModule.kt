package com.example.delivery.ui.viewmodel.di

import com.example.delivery.ui.viewmodel.HomeScreenViewModel
import com.example.delivery.ui.viewmodel.ProductFormScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeScreenViewModel()
    }
    viewModel {
        ProductFormScreenViewModel()
    }
}