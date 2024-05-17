package com.example.ecommerceappjetpackcompose.dashboard_screens.tab_screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ecommerceappjetpackcompose.R
import com.example.ecommerceappjetpackcompose.dashboard_screens.navigation.Screen
import com.example.ecommerceappjetpackcompose.dashboard_screens.viewmodel.SharedViewModel
import com.example.ecommerceappjetpackcompose.ui.theme.*

@Composable
fun ProductDetailsScreen(navController: NavHostController, viewModel: SharedViewModel) {

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBarWithBack(viewModel = viewModel,
                onBackClick = {
                    navController.navigateUp()
                },
            )
        }, backgroundColor = lightgraybg,
        floatingActionButton = {
        },

        content = {

            Box(modifier = Modifier.fillMaxSize())
            {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(30.dp)
                        .padding(bottom = 50.dp)
                ) {
                    item {
                        Box(
                            modifier = Modifier
                                .height(280.dp)
                        ) {
                            HeaderImagesSlider(viewModel)
                        }

                        ProductTitle(viewModel)
                        Spacer(modifier = Modifier.padding(10.dp))
                        ProductItemColorWithDesc(viewModel)
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {

                    var isAddedToCart by remember {
                        mutableStateOf(false)
                    }

                    Button(modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            if (isAddedToCart) {
                                navController.navigate(Screen.AddToCartScreen.route)
                            } else {
                                viewModel.cartProducts.add(viewModel.selectedProduct)

                                Toast.makeText(
                                    context,
                                    "Product added to cart", Toast.LENGTH_LONG
                                ).show()

                            }

                            isAddedToCart = true
                        }) {

                        Text(text = if (isAddedToCart) "Go to cart" else "Add to cart")
                    }
                }
            }
        }
    )
}


@Composable
fun HeaderImagesSlider(viewModel: SharedViewModel) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            contentScale = ContentScale.Fit,
            painter = painterResource(id = viewModel.selectedProduct.image),
            contentDescription = "",
            modifier = Modifier
                .size(230.dp)
        )
    }
}

@Composable
fun ProductTitle(viewModel: SharedViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Divider(
            color = grey,
            modifier = Modifier
                .height(4.dp)
                .width(40.dp)
        )
        Spacer(modifier = Modifier.padding(5.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = viewModel.selectedProduct.name,
                color = titleTextColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Column(modifier = Modifier.wrapContentHeight()) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                orange,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("₹ ")
                        }
                        withStyle(
                            style = SpanStyle(
                                titleTextColor
                            )
                        ) {
                            append(viewModel.selectedProduct.price.toString())
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


@Composable
fun ProductItemColorWithDesc(viewModel: SharedViewModel) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "Description",
            color = titleTextColor,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = viewModel.selectedProduct.details,
            color = lightblack,
            fontSize = 14.sp
        )
    }

}


@Composable
fun TopAppBarWithBack(viewModel: SharedViewModel,onBackClick: () -> Unit) {

    var isChecked by remember {
        mutableStateOf(viewModel.favoriteProducts.contains(viewModel.selectedProduct))
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Card(
            modifier = Modifier.width(50.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = 5.dp
        ) {
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowLeft,
                    contentDescription = ""
                )
            }

        }
        Card(
            modifier = Modifier.width(50.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = 5.dp
        ) {
            IconButton(onClick = {
                isChecked = !isChecked

                if (isChecked) {
                    viewModel.favoriteProducts.add(viewModel.selectedProduct)
                } else {
                    viewModel.favoriteProducts.remove(viewModel.selectedProduct)
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

        }
    }
}





