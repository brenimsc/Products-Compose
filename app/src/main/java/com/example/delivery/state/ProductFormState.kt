package com.example.delivery.state

data class ProductFormState(
    val url: String = "",
    val onUrlChange: (String) -> Unit = {},
    val name: String = "",
    val onNameChange: (String) -> Unit = {},
    val price: String = "",
    val onPriceChange: (String) -> Unit = {},
    val description: String = "",
    val onDescriptionChange: (String) -> Unit = {},
) {
    val isShowImagePreview get() = url.isNotBlank()
    val saveEnabled get() = url.isNotBlank() && name.isNotBlank() && price.isNotBlank() && description.isNotBlank()
}