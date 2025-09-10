package com.example.delivery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.delivery.components.CardProductItem
import com.example.delivery.components.ProductSection
import com.example.delivery.components.SearchTextField
import com.example.delivery.components.StoreSection
import com.example.delivery.sampleProductSection
import com.example.delivery.sampleStoreSections
import com.example.delivery.state.HomeScreenUiState
import com.example.delivery.ui.viewmodel.HomeScreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen() {
    val viewModel: HomeScreenViewModel = koinViewModel()
    val state by viewModel.uiState.collectAsState()

    HomeScreen(
        state = state
    )
}

@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState()
) {
    Column {
        val sections = state.sections
        val stores = state.stores
        val searchedFiltered = state.searchFiltered
        val text = state.searchText

        SearchTextField(
            searchText = text,
            onStateChanged = state.onSearchChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp),
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            when {
                state.isShowSections() -> {
                    takeIf { sections.isNotEmpty() }?.run {
                        items(sections) { item ->
                            ProductSection(item.first, item.second)
                        }

                        items(stores) { item ->
                            StoreSection(item.first, item.second)
                        }
                    } ?: item {
                        Text(
                            "Não encontrei produtos",
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }
                }

                else -> {
                    takeIf { searchedFiltered.isNotEmpty() }?.run {
                        items(searchedFiltered) { item ->
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

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        HomeScreenUiState(
            sections = sampleProductSection,
            stores = sampleStoreSections
        )
    )
}
