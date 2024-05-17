package com.example.ecommerceappjetpackcompose.utils.widgets

import androidx.compose.material.Button
import androidx.compose.runtime.Composable

@Composable
fun ButtonPrimary(text: String, onClick: () -> Unit) {

    Button(onClick = { onClick() }) {
        TextPrimaryWhite(text)
    }
}