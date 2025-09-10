package com.example.delivery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.delivery.sampleProductSection
import com.example.delivery.sampleStoreSections
import com.example.delivery.state.HomeScreenUiState
import com.example.delivery.ui.screens.HomeScreen
import com.example.delivery.ui.theme.DeliveryTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App(
                onButtonClick = {
                    goToCreateProduct()
                }
            ) {
                HomeScreen()
            }
        }
    }

    private fun goToCreateProduct() {
        Intent(this, ProductFormActivity::class.java).run {
            startActivity(this)
        }
    }
}

@Composable
fun App(onButtonClick: () -> Unit = {}, content: @Composable () -> Unit = {}) {
    DeliveryTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Scaffold(floatingActionButton = {
                FloatingActionButton(onClick = {
                    onButtonClick()
                }) {
                    Icon(
                        imageVector = Icons.Default.Add, contentDescription = null
                    )
                }
            }) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    content()
                }
            }
        }
    }
}

@Preview
@Composable
private fun AppPreview() {
    App {
        HomeScreen(
            HomeScreenUiState(
                sections = sampleProductSection,
                stores = sampleStoreSections
            )
        )
    }
}
