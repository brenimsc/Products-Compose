package com.example.delivery.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.delivery.dao.ProductDao
import com.example.delivery.extensions.formatPrice
import com.example.delivery.model.Product
import com.example.delivery.state.ProductFormState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.math.BigDecimal

class ProductFormScreenViewModel : ViewModel() {

    private val dao = ProductDao()
    private val _uiState: MutableStateFlow<ProductFormState> = MutableStateFlow(
        ProductFormState()
    )

    val uiState get() = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                onUrlChange = {
                    _uiState.value = _uiState.value.copy(url = it)
                },
                onNameChange = {
                    _uiState.value = _uiState.value.copy(name = it)
                },
                onPriceChange = {
                    _uiState.value = _uiState.value.copy(price = it.formatPrice() ?: return@copy)
                },
                onDescriptionChange = {
                    _uiState.value = _uiState.value.copy(description = it)
                }
            )
        }
    }

    fun save() {
        _uiState.value.run {
            dao.save(
                Product(
                    name = name,
                    price = BigDecimal(price),
                    description = description,
                    imageUrl = url
                )
            )
        }
    }
}
