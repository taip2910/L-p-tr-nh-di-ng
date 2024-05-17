package com.example.ecommerceappjetpackcompose.utils.widgets

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TextPrimaryWhite(text:String){

    Text(text = text, fontSize = 15.sp, fontWeight = FontWeight.Normal, color = Color.White)
}