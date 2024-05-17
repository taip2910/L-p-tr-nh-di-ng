package com.example.firebaseproject

import com.google.firebase.firestore.Exclude

data class Product(
    // on below line creating variables.
    @Exclude var productID: String? = "",
    var productName: String? = "",
    var productCost: String? = "",
    var productImage: String? = ""



)
