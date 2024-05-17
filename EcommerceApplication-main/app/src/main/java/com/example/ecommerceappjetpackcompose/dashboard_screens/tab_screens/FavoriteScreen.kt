package com.example.ecommerceappjetpackcompose.dashboard_screens.tab_screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ecommerceappjetpackcompose.dashboard_screens.viewmodel.SharedViewModel
import com.example.ecommerceappjetpackcompose.ui.theme.subTitleTextColor
import com.example.ecommerceappjetpackcompose.ui.theme.titleTextColor

@Composable
fun FavoriteScreen(navController: NavHostController, viewModel: SharedViewModel) {
    val search = remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(30.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top
            ) {

                Text(
                    buildAnnotatedString {
                        withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                            withStyle(
                                style = SpanStyle(
                                    color = subTitleTextColor,
                                    fontSize = 24.sp
                                )
                            ) {
                                append("Favorite\n")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Bold,
                                    color = titleTextColor,
                                    fontSize = 24.sp
                                )
                            ) {
                                append("Products")
                            }

                        }
                    }
                )
            }
            Spacer(modifier = Modifier.padding(20.dp))
            ProductWidget(navController, viewModel, viewModel.favoriteProducts, search)
        }
    }
}