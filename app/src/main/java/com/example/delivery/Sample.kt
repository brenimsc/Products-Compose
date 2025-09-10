package com.example.delivery

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.example.delivery.model.Product
import java.math.BigDecimal

val sampleProducts = listOf(
    Product(
        name = "Hamburguer",
        price = BigDecimal("14.99"),
        imageUrl = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg"
    ),
    Product(
        name = "Pizza",
        price = BigDecimal("18.99"),
        imageUrl = "https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg",
        description = LoremIpsum(50).values.first()
    ),
    Product(
        name = "Batata frita",
        price = BigDecimal("200.00"),
        imageUrl = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg"
    ),
    Product(
        name = "Agua",
        price = BigDecimal("5.00"),
        imageUrl = "https://images.pexels.com/phssotos/1583884/pexels-photo-1583884.jpeg",
        description = LoremIpsum(30).values.first()
    ),
    Product(
        name = "Refresco",
        price = BigDecimal("10.00"),
        imageUrl = "https://images.pexels.com/phssotos/1583884/pexels-photo-1583884.jpeg",
        description = LoremIpsum(20).values.first()
    ),
    Product(
        name = "Hamburguer",
        price = BigDecimal("14.99"),
        imageUrl = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg"
    ),
    Product(
        name = "Pizza",
        price = BigDecimal("18.99"),
        imageUrl = "https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg"
    ),
    Product(
        name = "Batata frita",
        price = BigDecimal("200.00"),
        imageUrl = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg"
    )
)

val sampleProductSection = listOf(
    Pair("Comidas", sampleProducts),
    Pair("Doces", sampleProducts),
    Pair("Bebidas", sampleProducts),
)