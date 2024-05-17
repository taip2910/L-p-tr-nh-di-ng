package com.example.ecommerceappjetpackcompose.dashboard_screens.tab_screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ecommerceappjetpackcompose.dashboard_screens.viewmodel.SharedViewModel
import com.example.ecommerceappjetpackcompose.ui.theme.lightsilverbox
import com.example.ecommerceappjetpackcompose.ui.theme.orange
import com.example.ecommerceappjetpackcompose.ui.theme.subTitleTextColor
import com.example.ecommerceappjetpackcompose.ui.theme.titleTextColor

@Composable
fun OrderHistoryScreen(navController: NavHostController, viewModel: SharedViewModel) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
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
                            append("Order\n")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = titleTextColor,
                                fontSize = 24.sp
                            )
                        ) {
                            append("History")
                        }

                    }
                }
            )

            HistoryItemList(viewModel)
            Spacer(modifier = Modifier.padding(20.dp))
        }
    }
}

@Composable
fun HistoryItemList(viewModel: SharedViewModel) {
    Column(
        modifier = Modifier.fillMaxSize().padding(top = 20.dp),
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        if (viewModel.historyProducts.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "No products history")
            }
        }

        Log.d("historyProducts2","historyProducts2 size ${viewModel.historyProducts.size}")

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            itemsIndexed(viewModel.historyProducts.distinct()) { _, item ->

                ProductHistoryItems(
                    imagePainter = painterResource(id = item.image),
                    title = item.name,
                    price = item.price.toString(),
                    backgroundColor = lightsilverbox
                )
            }
        }
    }
}

@Composable
fun ProductHistoryItems(
    imagePainter: Painter,
    title: String = "",
    price: String = "",
    backgroundColor: Color = Color.Transparent
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .fillMaxWidth(0.2f)
                .clip(RoundedCornerShape(20.dp))
                .background(backgroundColor),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = imagePainter,
                contentDescription = "",
                modifier = Modifier.padding(8.dp),
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
                color = titleTextColor,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                orange,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("₹")
                        }
                        withStyle(
                            style = SpanStyle(
                                titleTextColor
                            )
                        ) {
                            append(price)
                        }
                    },
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier,
                    fontSize = 16.sp

                )
            }

        }
    }
}
