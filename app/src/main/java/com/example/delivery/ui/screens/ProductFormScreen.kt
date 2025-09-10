package com.example.delivery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.delivery.R
import com.example.delivery.state.ProductFormState
import com.example.delivery.ui.theme.DeliveryTheme
import com.example.delivery.ui.viewmodel.ProductFormScreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProductFormScreen(
    state: ProductFormState = ProductFormState(),
    onSaveClick: () -> Unit = {}
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
            .imePadding(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(Modifier)
        Text("Criando o produto", Modifier.fillMaxWidth(), fontSize = 28.sp)

        val url = state.url
        val name = state.name
        val price = state.price
        val description = state.description

        takeIf { state.isShowImagePreview }?.run {
            AsyncImage(
                model = url,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(R.drawable.ic_launcher_foreground)
            )
        }
        TextField(
            value = url,
            onValueChange = state.onUrlChange,
            Modifier.fillMaxWidth(),
            label = {
                Text(text = "Url da imagem")
            }, keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = name,
            onValueChange = state.onNameChange,
            Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nome")
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            )
        )

        TextField(
            value = price,
            onValueChange = state.onPriceChange,
            Modifier.fillMaxWidth(),
            label = {
                Text(text = "Preço")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = description,
            onValueChange = state.onDescriptionChange,
            Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp), label = {
                Text(text = "Descrição")
            }, keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences
            )
        )

        Button(
            onClick = onSaveClick,
            enabled = state.saveEnabled,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Salvar")
        }
        Spacer(Modifier)
    }
}

@Composable
fun ProductFormScreen(
    onSaveClick: () -> Unit
) {
    val viewModel: ProductFormScreenViewModel = koinViewModel()
    val state by viewModel.uiState.collectAsState()
    ProductFormScreen(state = state, onSaveClick = {
        viewModel.save()
        onSaveClick.invoke()
    })
}

@Preview(showSystemUi = true)
@Composable
private fun ProductFormScreenPreview() {
    DeliveryTheme {
        Surface {
            ProductFormScreen(ProductFormState())
        }
    }
}