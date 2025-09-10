package com.example.delivery.state

import com.example.delivery.model.Product
import com.example.delivery.model.Store

data class HomeScreenUiState(
    val sections: List<Pair<String, List<Product>>> = emptyList(),
    val stores: List<Pair<String, List<Store>>> = emptyList(),
    val searchText: String = "",
    val onSearchChange: (String) -> Unit = {},
    val searchFiltered: List<Product> = emptyList()
) {
    fun isShowSections() = searchText.isBlank()
}