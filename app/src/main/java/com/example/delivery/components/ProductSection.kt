package com.example.delivery.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.delivery.model.Product
import com.example.delivery.sampleSavory

@Composable
fun ProductSection(
    title: String,
    products: List<Product>,
    modifier: Modifier = Modifier
) {
    Section(
        title = {
        Text(
            text = title,
            modifier = Modifier.padding(
                horizontal = 16.dp
            ),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
    }, content = {
        LazyRow(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(products) { item ->
                ProductItem(item)
            }
        }
    },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductSectionPreview() {
    Column {
        ProductSection(title = "Comidas", sampleSavory)
        ProductSection(title = "Bebidas", sampleSavory)
        ProductSection(title = "Doces", sampleSavory)
    }
}