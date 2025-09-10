package com.example.delivery.dao.di

import com.example.delivery.dao.ProductDao
import org.koin.dsl.module

val daoModule = module {
    single {
        ProductDao()
    }
}