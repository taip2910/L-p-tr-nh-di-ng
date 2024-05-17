package com.example.log


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import java.util.UUID

// Import your data class definition here
data class Product(
    val id: String = "", // Unique identifier for each product
    val name: String,
    val price: Double,
    val category: String,
    val imageUrl: String // Can be a text link, 64-bit string, or Firebase storage link
)

@Composable
fun AddProductScreen(
    onProductAdded: (Product) -> Unit, // Callback to notify when a product is added
) {
    var productName by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf(0.0) }
    var productCategory by remember { mutableStateOf("") }
    var productImageURL by remember { mutableStateOf("") }

    Column {
        TextField(
            value = productName,
            onValueChange = { productName = it },
            label = { Text("Product Name") }
        )
        TextField(
            value = productPrice.toString(),
            onValueChange = { productPrice = it.toDoubleOrNull() ?: 0.0 },
            label = { Text("Product Price") }
        )
        TextField(
            value = productCategory,
            onValueChange = { productCategory = it },
            label = { Text("Product Category") }
        )
        TextField(
            value = productImageURL,
            onValueChange = { productImageURL = it },
            label = { Text("Product Image URL") }
        )
        Button(onClick = {
            val product = Product(
                id = UUID.randomUUID().toString(), // Generate unique ID
                name = productName,
                price = productPrice,
                category = productCategory,
                imageUrl = productImageURL
            )
            onProductAdded(product) // Notify parent screen about new product
        }) {
            Text("Add Product")
        }
    }
}
@Composable
fun ProductListScreen(
    products: List<Product>, // List of products to display
    onProductSelected: (Product) -> Unit, // Callback to notify when a product is selected
    onDeleteProduct: (Product) -> Unit // Callback to notify when a product is deleted
) {
    LazyColumn {
        items(products) { product ->
            ProductListItem(product, onProductSelected, onDeleteProduct)
        }
    }
}
@Composable
fun ProductListItem(
    product: Product,
    onProductSelected: (Product) -> Unit,
    onDeleteProduct: (Product) -> Unit
) {
    Card(
        onClick = { onProductSelected(product) },
        elevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            CoilImage(
                data = product.imageUrl,
                contentDescription = product.name,
                modifier = Modifier
                    .size(80.dp)
                    .aspectRatio(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(product.name, fontWeight = FontWeight.Bold)
                Text("$ ${product.price}")
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { onDeleteProduct(product) }) {
                Icon(Icons.Filled.Delete, contentDescription = "Delete")
            }
        }
    }
}
@Composable
fun AdminScreen(
    productRepository: ProductRepository, // Repository to manage product data
) {
    var products by remember { mutableStateOf(emptyList<Product>()) } // List of products
    var showAddProductDialog by remember { mutableStateOf(false) } // Flag to show add product dialog

    LaunchedEffect(Unit) { // Load products on initial launch
        products = productRepository.getProducts()
    }

    Column {
        Button(onClick = { showAddProductDialog = true }) {
            Text("Add Product")
        }
        Spacer(modifier = Modifier.height(16.dp))
        ProductListScreen(
            products = products,
            onProductSelected = { product ->
//
