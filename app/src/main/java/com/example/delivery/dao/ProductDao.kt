package com.example.delivery.dao

import com.example.delivery.model.Product
import com.example.delivery.model.Store
import com.example.delivery.sampleCandies
import com.example.delivery.sampleDrinks
import com.example.delivery.sampleSavory
import com.example.delivery.sampleStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProductDao {

    companion object {
        private val savory = sampleSavory
        private val candies = sampleCandies
        private val drinks = sampleDrinks
        private val products: MutableStateFlow<List<Product>> = MutableStateFlow(savory + candies + sampleDrinks)

        private val stores = sampleStore
    }

    fun getProducts() = products.asStateFlow()

    fun save(product: Product) {
        products.update {
            it + product
        }
    }

    fun getProductsSection(products: List<Product>): List<Pair<String, List<Product>>> = listOf(
        Pair("Todos os produtos", products),
        Pair("Salgados", savory),
        Pair("Doces", candies),
        Pair("Bebidas", drinks),
    )

    fun getStores(): List<Pair<String, List<Store>>> = listOf(
        Pair("Lojas parceiras", stores)
    )
}