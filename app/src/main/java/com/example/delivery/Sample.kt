package com.example.delivery

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.example.delivery.model.Product
import com.example.delivery.model.Store
import java.math.BigDecimal

val sampleStore = listOf(
    Store(
        name = "Carrinho SuperMercado",
        imageUrl = "https://images.pexels.com/photos/264547/pexels-photo-264547.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
    ),
    Store(
        name = "Padaria",
        imageUrl = "https://images.pexels.com/photos/1855214/pexels-photo-1855214.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
    ),
    Store(
        name = "Floricultura",
        imageUrl = "https://images.pexels.com/photos/2111192/pexels-photo-2111192.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
    ),
    Store(
        name = "Loja de Roupas",
        imageUrl = "https://images.pexels.com/photos/102129/pexels-photo-102129.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
    ),
    Store(
        name = "Hotéis",
        imageUrl = "https://images.pexels.com/photos/237272/pexels-photo-237272.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
    ),
)

val sampleStoreSections = listOf(
    Pair(
        "Lojas Parceiras", sampleStore
    )
)

val sampleCandies = listOf(
    Product(
        name = "Chocolate",
        price = BigDecimal("3.99"),
        imageUrl = "https://images.pexels.com/photos/65882/chocolate-dark-coffee-confiserie-65882.jpeg",
    ),
    Product(
        name = "Sorvete",
        price = BigDecimal("5.99"),
        imageUrl = "https://images.pexels.com/photos/1352278/pexels-photo-1352278.jpeg",
        description = LoremIpsum(5).values.first()
    ),
    Product(
        name = "Bolo",
        price = BigDecimal("11.99"),
        imageUrl = "https://images.pexels.com/photos/291528/pexels-photo-291528.jpeg",
    )
)

val sampleDrinks = listOf(
    Product(
        name = "Cerveja",
        price = BigDecimal("5.99"),
        imageUrl = "https://images.pexels.com/photos/1552630/pexels-photo-1552630.jpeg",
        description = LoremIpsum(20).values.first()
    ),
    Product(
        name = "Refrigerante",
        price = BigDecimal("4.99"),
        imageUrl = "https://images.pexels.com/photos/2775860/pexels-photo-2775860.jpeg"
    ),
    Product(
        name = "Suco",
        price = BigDecimal("7.99"),
        imageUrl = "https://images.pexels.com/photos/96974/pexels-photo-96974.jpeg",
        description = LoremIpsum(100).values.first()
    ),
    Product(
        name = "Água",
        price = BigDecimal("2.99"),
        imageUrl = "https://images.pexels.com/photos/327090/pexels-photo-327090.jpeg"
    )
)

val sampleSavory: List<Product> = listOf(
    Product(
        name = "Hamburguer",
        price = BigDecimal("12.99"),
        imageUrl = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg",
        description = LoremIpsum(20).values.first()
    ),
    Product(
        name = "Pizza",
        price = BigDecimal("19.99"),
        imageUrl = "https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg"
    ),
    Product(
        name = "Batata frita",
        price = BigDecimal("7.99"),
        imageUrl = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
        description = LoremIpsum(50).values.first()
    )
)

val sampleAllProducts = sampleSavory + sampleCandies + sampleDrinks

val sampleProductSection = listOf(
    Pair("Todos os produtos", sampleSavory + sampleCandies + sampleDrinks),
    Pair("Comidas", sampleSavory),
    Pair("Doces", sampleCandies),
    Pair("Bebidas", sampleDrinks),
)