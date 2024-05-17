package com.example.ecommerceappjetpackcompose.dashboard_screens.tab_screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ecommerceappjetpackcompose.R
import com.example.ecommerceappjetpackcompose.dashboard_screens.navigation.Screen
import com.example.ecommerceappjetpackcompose.dashboard_screens.viewmodel.SharedViewModel
import com.example.ecommerceappjetpackcompose.ui.theme.*

@Composable
fun HomeScreen(navController: NavHostController, viewModel: SharedViewModel) {

    val search = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 20.dp)) {
            Products(search)
            Spacer(modifier = Modifier.padding(20.dp))
            ProductCategory()
            ProductWidget(navController, viewModel, viewModel.productDetailsList, search)
        }
    }


}

@Composable
fun Products(search: MutableState<String>) {

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
                        append("Our\n")
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

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = lightbox,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                value = search.value,
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                onValueChange = { search.value = it },
                placeholder = {
                    Text(
                        text = "Search Products",
                        color = lightGrey
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "",
                        tint = lightblack
                    )
                },
            )
        }
    }
}

@Composable
fun ProductCategory() {
    val itemList = listOf("GamePads", "Sneakers", "Watch")
    val categoryImagesList = listOf(
        R.drawable.zebmax,
        R.drawable.shoe_thumb_2,
        R.drawable.watch
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(itemList.size) { item ->
            Box(
                modifier = Modifier
                    .border(
                        color = if (item == 0) orange else lightGrey,
                        width = 2.dp,
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                Row(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(categoryImagesList[item]),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp, 30.dp)
                    )
                    Text(
                        modifier = Modifier
                            .padding(
                                start = 5.dp,
                                end = 16.dp,
                                top = 8.dp,
                                bottom = 8.dp
                            ),
                        text = itemList[item],
                        color = if (item == 0) lightblack else Color.LightGray
                    )
                }

            }
        }
    }
}

data class ProductDetails(
    val name: String,
    val details: String,
    val price: Int,
    val image: Int,
    val trending: String
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductWidget(
    navController: NavHostController,
    viewModel: SharedViewModel,
    productDetailsList: List<ProductDetails>,
    search: MutableState<String>
) {

    if (productDetailsList.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "No favorite products!")
        }
    }

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        content = {
            itemsIndexed(productDetailsList.filter {
                it.name.contains(search.value, ignoreCase = true)
                        || it.details.contains(search.value, ignoreCase = true)
            }) { _, item ->

                var isChecked by remember {
                    mutableStateOf(viewModel.favoriteProducts.contains(item))
                }

                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            viewModel.selectedProduct = item
                            navController.navigate(Screen.ProductDetailsScreen.route)
                        }
                        .wrapContentHeight(),
                    shape = RoundedCornerShape(24.dp),
                    elevation = 2.dp
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(12.dp)
                    ) {
                        IconButton(onClick = {
                            isChecked = !isChecked

                            if (isChecked) {
                                viewModel.favoriteProducts.add(item)
                            } else {
                                viewModel.favoriteProducts.remove(item)
                            }
                        }) {
                            Icon(
                                painter = painterResource(
                                    id =
                                    if (isChecked) {
                                        R.drawable.ic_baseline_favorite_24
                                    } else {
                                        R.drawable.ic_baseline_favorite_border_24
                                    }
                                ),
                                contentDescription = "",
                                tint = if (isChecked) redHeart else lightGrey
                            )

                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(100.dp),
                                painter = painterResource(item.image),
                                contentDescription = "",
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {

                            Text(
                                text = item.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = titleTextColor,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )

                            Text(
                                text = item.trending,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = orange,
                                modifier = Modifier.padding(bottom = 10.dp)
                            )

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
                                        append(item.price.toString())
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
        }
    )
}
