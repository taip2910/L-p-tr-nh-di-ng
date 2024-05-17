package com.example.firebaseproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.widget.Toast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface


import androidx.compose.material3.TextField

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import com.example.firebaseproject.ui.theme.FirebaseprojectTheme
import com.example.firebaseproject.ui.theme.blueColor
import com.example.firebaseproject.ui.theme.greenColor

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import java.util.UUID


class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
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
                                    // in the top bar we are
                                    // specifying tile as a text
                                    Text(
                                        // on below line we are specifying
                                        // text to display in top app bar
                                        text = "SẢN PHẨM",
                                        // on below line we are specifying
                                        // modifier to fill max width
                                        modifier = Modifier.fillMaxWidth(),
                                        // on below line we are
                                        // specifying text alignment
                                        textAlign = TextAlign.Center,
                                        // on below line we are specifying
                                        // color for our text.
                                        color = Color.White
                                    )
                                })
                        }) {innerPadding ->
                        Text(
                            modifier = Modifier.padding(innerPadding),
                            text = "Them du lieu."
                        )
                        // on below line we are calling
                        // method to display UI
                        FirebaseUI(LocalContext.current)
                    }
                }
            }
        }
    }
}





@Composable
fun FirebaseUI(context: Context) {

    // on below line creating variable for product name,
    // product duration and product description.
    val productID = remember {
        mutableStateOf("")
    }
    val productName = remember {
        mutableStateOf("")
    }

    val productDuration = remember {
        mutableStateOf("")
    }

    val productDescription = remember {
        mutableStateOf("")
    }

    // on below line creating a column
    // to display our retrieved image view.
    Column(
        // adding modifier for our column
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.White),
        // on below line adding vertical and
        // horizontal alignment for column.
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {


        TextField(
            // on below line we are specifying
            // value for our product name text field.
            value = productName.value,

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
            value = productDuration.value,

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
            value = productDescription.value,

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
                    Toast.makeText(context, "Please enter product name", Toast.LENGTH_SHORT).show()
                } else if (TextUtils.isEmpty(productDuration.value.toString())) {
                    Toast.makeText(context, "Please enter product Duration", Toast.LENGTH_SHORT)
                        .show()
                } else if (TextUtils.isEmpty(productDescription.value.toString())) {
                    Toast.makeText(context, "Please enter product description", Toast.LENGTH_SHORT)
                        .show()
                } else {

                    productID.value  = UUID.randomUUID().toString()
                    // on below line adding data to firebase firestore database.
                    addDataToFirebase(productID.value, productName.value, productDuration.value, productDescription.value, context)




                }
            },
            // on below line we are
            // adding modifier to our button.
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // on below line we are adding text for our button
            Text(text = "Add Data", modifier = Modifier.padding(8.dp))
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                // on below line opening product details activity.
                context.startActivity(Intent(context, ProductDetailsActivity::class.java))
            },
            // on below line we are
            // adding modifier to our button.
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // on below line we are adding text for our button
            Text(text = "View Products", modifier = Modifier.padding(8.dp))
        }


    }
}


fun addDataToFirebase(
    productID:String,productName: String, productDuration: String, productDescription: String, context: Context
) {
    // on below line creating an instance of firebase firestore.
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()

   // db.collection("Products").document(productID.toString()).set(updatedProduct)
    // creating a collection reference for our Firebase Firestore database.
    val dbProducts: CollectionReference = db.collection("Products")


    // adding our data to our products object class.
    val products = Product(productID,productName, productDuration,productDescription)

    // below method is use to add data to Firebase Firestore
    // after the data addition is successful
    dbProducts.add(products).addOnSuccessListener {
        // we are displaying a success toast message.
        Toast.makeText(
            context, "Your Product has been added to Firebase Firestore", Toast.LENGTH_SHORT
        ).show()

    }.addOnFailureListener { e ->
        // this method is called when the data addition process is failed.
        // displaying a toast message when data addition is failed.
        Toast.makeText(context, "Fail to add product \n$e", Toast.LENGTH_SHORT).show()
    }

}