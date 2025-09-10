package com.example.delivery.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.delivery.model.Store
import com.example.delivery.sampleStoreSections
import com.example.delivery.ui.theme.DeliveryTheme

@Composable
fun StoreSection(
    title: String,
    stores: List<Store>,
    modifier: Modifier = Modifier
) {
    Section(
        title = {
            Text(
                text = title,
                Modifier.padding(
                    start = 16.dp,
                    end = 16.dp
                ),
                fontSize = 20.sp,
                fontWeight = FontWeight(400),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        },
        content = {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(stores) {
                    StoreItem(
                        store = it
                    )
                }
            }
        },
        modifier = modifier
    )
}

@Preview(showSystemUi = true)
@Composable
private fun StoreSectionPreview() {
    DeliveryTheme {
        StoreSection(
            stores = sampleStoreSections[0].second,
            title = "Nossos parceiros",
            modifier = Modifier.padding(16.dp)
        )
    }
}