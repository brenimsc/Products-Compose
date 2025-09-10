package com.example.delivery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.delivery.components.CardProductItem
import com.example.delivery.components.ProductItem
import com.example.delivery.components.ProductSection
import com.example.delivery.components.SearchTextField
import com.example.delivery.model.Product
import com.example.delivery.sampleProductSection
import com.example.delivery.sampleProducts

@Composable
fun HomeScreen(sections: List<Pair<String, List<Product>>>) {
    Column {
        var input by remember { mutableStateOf("") }
        SearchTextField(
            input,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            input = it
        }

        val searchFiltered = remember(input) {
            sampleProducts.filter { product ->
                product.name.contains(input, true)
            }
        }

        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp),
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            when {
                input.isBlank() -> {
                    takeIf { sections.isNotEmpty() }?.run {
                        items(sections) { item ->
                            ProductSection(item.first, item.second)
                        }
                    } ?: item {
                        Text(
                            "Não encontrei produtos",
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }
                }

                else -> {
                    takeIf { searchFiltered.isNotEmpty() }?.run {
                        items(searchFiltered) { item ->
                            CardProductItem(
                                modifier = Modifier.padding(horizontal = 16.dp),
                                product = item
                            )
                        }
                    } ?: item {
                        Text(
                            "Não encontrei produtos",
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreenGrid(products: List<Product>) {
    LazyVerticalGrid(
        modifier = Modifier,
        contentPadding = PaddingValues(16.dp),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item(span = {
            GridItemSpan(maxLineSpan)
        }) {
            Text("Todos os produtos", fontSize = 32.sp)
        }

        items(products) { item ->
            ProductItem(item)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(sampleProductSection)
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenGridPreview() {
    HomeScreenGrid(sampleProducts)
}
