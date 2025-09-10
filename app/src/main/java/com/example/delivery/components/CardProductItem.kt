package com.example.delivery.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.delivery.extensions.toBrazilianCurrency
import com.example.delivery.model.Product
import com.example.delivery.sampleProducts
import com.example.delivery.ui.theme.DeliveryTheme
import com.example.delivery.ui.theme.Purple80
import java.math.BigDecimal

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier
) {
    var expandend by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .clickable {
                expandend = !expandend
            },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Purple80)
                    .padding(16.dp)
            ) {
                Text(
                    product.name,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 4
                )
                Text(
                    product.price.toBrazilianCurrency(),
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1
                )
            }

            product.description?.let {

                Text(
                    text = product.description,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                        .fillMaxWidth(),
                    color = Color.Black,
                    overflow = takeIf { expandend }?.run { TextOverflow.Visible }
                        ?: TextOverflow.Ellipsis,
                    maxLines = takeIf { expandend }?.run { Int.MAX_VALUE } ?: 4
                )

                Icon(
                    takeIf { expandend }?.run { Icons.Default.KeyboardArrowUp }
                        ?: Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier
                        .align(androidx.compose.ui.Alignment.CenterHorizontally)
                        .padding(bottom = 8.dp, end = 16.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun CardProductPreview() {
    DeliveryTheme {
        Surface {
            CardProductItem(product = sampleProducts.random())
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun CardProductWithDescriptionPreview() {
    DeliveryTheme {
        Surface {
            CardProductItem(
                product = Product(
                    name = "Teste",
                    price = BigDecimal("10.00"),
                    imageUrl = "",
                    description = LoremIpsum(50).values.first()
                )
            )
        }
    }
}