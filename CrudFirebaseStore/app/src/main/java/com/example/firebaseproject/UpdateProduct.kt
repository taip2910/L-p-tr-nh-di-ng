package com.example.firebaseproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import com.example.firebaseproject.ui.theme.FirebaseprojectTheme
import android.content.Context
import android.content.Intent

import android.text.TextUtils

import android.widget.Toast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firebaseproject.ui.theme.blueColor

import com.google.firebase.firestore.FirebaseFirestore

class UpdateProduct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirebaseprojectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Scaffold(
                        // in scaffold we are specifying the top bar.
                        topBar = {
                            // inside top bar we are specifying
                            // background color.
                            TopAppBar(backgroundColor = blueColor,
                                // along with that we are specifying
                                // title for our top bar.
                                title = {
                                    // in the top bar we are specifying
                                    // title as a text
                                    Text(
                                        // on below line we are specifying
                                        // text to display in top app bar
                                        text = "Product",
                                        // on below line we are specifying
                                        // modifier to fill max width
                                        modifier = Modifier.fillMaxWidth(),
                                        // on below line we are specifying
                                        // text alignment
                                        textAlign = TextAlign.Center,
                                        // on below line we are specifying
                                        // color for our text.
                                        color = Color.White
                                    )
                                })
                        }) { innerPadding ->
                        Text(
                            modifier = Modifier.padding(innerPadding),
                            text = "Cap nhat du lieu."
                        )

                        // on below line getting data from our database
                        // on below line we are calling method to display UI
                        firebaseUI(
                            LocalContext.current,
                            intent.getStringExtra("productName"),
                            intent.getStringExtra("productDuration"),
                            intent.getStringExtra("productDescription"),
                            intent.getStringExtra("productID")
                        )


                    }
                }
            }
        }
    }


    // cap nhat
    @Composable
    fun firebaseUI(
        context: Context,
        name: String?,
        duration: String?,
        description: String?,
        productID: String?
    ) {

        // on below line creating variable for product name,
        // product duration and product description.
        val productName = remember {
            mutableStateOf(name)
        }

        val productDuration = remember {
            mutableStateOf(duration)
        }

        val productDescription = remember {
            mutableStateOf(description)
        }

        // on below line creating a column
        Column(
            // adding modifier for our column
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color.White),
            // on below line adding vertical and
            // horizontal alignment for column.
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            TextField(
                // on below line we are specifying
                // value for our product name text field.
                value = productName.value.toString(),

                // on below line we are adding on
                // value change for text field.
                onValueChange = { productName.value = it },

                // on below line we are adding place holder
                // as text as "Enter your product name"
                placeholder = { Text(text = "Enter your product name") },

                // on below line we are adding modifier to it
                // and adding padding to it and filling max width
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),

                // on below line we are adding text style
                // specifying color and font size to it.
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

                // on below line we are adding
                // single line to it.
                singleLine = true,
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                // on below line we are specifying
                // value for our product duration text field.
                value = productDuration.value.toString(),

                // on below line we are adding on
                // value change for text field.
                onValueChange = { productDuration.value = it },

                // on below line we are adding place holder
                // as text as "Enter your product duration"
                placeholder = { Text(text = "Enter your product duration") },

                // on below line we are adding modifier to it
                // and adding padding to it and filling max width
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),

                // on below line we are adding text style
                // specifying color and font size to it.
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

                // on below line we are adding
                // single line to it.
                singleLine = true,
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                // on below line we are specifying
                // value for our product description text field.
                value = productDescription.value.toString(),

                // on below line we are adding on
                // value change for text field.
                onValueChange = { productDescription.value = it },

                // on below line we are adding place holder
                // as text as "Enter your product description"
                placeholder = { Text(text = "Enter your product description") },

                // on below line we are adding modifier to it
                // and adding padding to it and filling max width
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),

                // on below line we are adding text style
                // specifying color and font size to it.
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),

                // on below line we are adding
                // single line to it.
                singleLine = true,
            )

            Spacer(modifier = Modifier.height(10.dp))

            // on below line creating button to add data
            // to firebase firestore database.
            Button(
                onClick = {
                    // on below line we are validating user input parameters.
                    if (TextUtils.isEmpty(productName.value.toString())) {
                        Toast.makeText(context, "Please enter product name", Toast.LENGTH_SHORT)
                            .show()
                    } else if (TextUtils.isEmpty(productDuration.value.toString())) {
                        Toast.makeText(
                            context,
                            "Please enter product Duration",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else if (TextUtils.isEmpty(productDescription.value.toString())) {
                        Toast.makeText(
                            context,
                            "Please enter product description",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else {
                        // on below line adding data to
                        // firebase firestore database.
                        updateDataToFirebase(
                            productID,
                            productName.value,
                            productDuration.value,
                            productDescription.value,
                            context
                        )
                    }
                },
                // on below line we are
                // adding modifier to our button.
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // on below line we are adding text for our button
                Text(text = "Update Data", modifier = Modifier.padding(8.dp))
            }

            Spacer(modifier = Modifier.height(10.dp))
        }
    }

    private fun updateDataToFirebase(
        productID: String?,
        name: String?,
        duration: String?,
        description: String?,
        context: Context
    ) {
        // inside this method we are passing our updated values
        // inside our object class and later on we
        // will pass our whole object tofirebase Firestore.
        val updatedProduct = Product(productID, name, duration, description)

        // getting our instance from Firebase Firestore.
        val db = FirebaseFirestore.getInstance();
        db.collection("Products").document(productID.toString()).set(updatedProduct)
            .addOnSuccessListener {
                // on below line displaying toast message and opening
                // new activity to view products.
                Toast.makeText(context, "Product Updated successfully..", Toast.LENGTH_SHORT).show()
                context.startActivity(Intent(context, ProductDetailsActivity::class.java))
                //  finish()

            }.addOnFailureListener {
                Toast.makeText(context, "Fail to update product : " + it.message, Toast.LENGTH_SHORT)
                    .show()
            }
    }
}

