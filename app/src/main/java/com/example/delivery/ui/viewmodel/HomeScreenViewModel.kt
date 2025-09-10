package com.example.delivery.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.delivery.dao.ProductDao
import com.example.delivery.state.HomeScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {

    private val dao = ProductDao()

    private val _uiState: MutableStateFlow<HomeScreenUiState> = MutableStateFlow(
        HomeScreenUiState()
    )
    val uiState get() = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                onSearchChange = {
                    _uiState.value = _uiState.value.copy(
                        searchText = it,
                        searchFiltered = searchFiltered(it)
                    )
                }
            )
        }

        viewModelScope.launch {
            dao.getProducts().collect { products ->
                _uiState.update {
                    _uiState.value.copy(
                        sections = dao.getProductsSection(products),
                        searchFiltered = searchFiltered(_uiState.value.searchText)
                    )
                }
            }
        }
    }

    private fun searchFiltered(text: String) = if (text.isNotBlank()) {
        dao.getProducts().value.filter { product ->
            product.name.contains(text, true)
        }
    } else {
        emptyList()
    }
}