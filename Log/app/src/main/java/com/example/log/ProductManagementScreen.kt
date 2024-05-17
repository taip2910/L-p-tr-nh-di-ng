package com.example.log.com.example.log

import androidx.compose.foundation.* // For Column, Modifier, Row, Spacer, Card, etc.
import androidx.compose.foundation.layout.* // For fillMaxSize, padding, weight, etc.
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.* // For Text, Button, IconButton, Icon, etc.
import androidx.compose.material.icons.Icons // For Icons.Outlined.Delete
import androidx.compose.material.icons.outlined // For Icons.Outlined.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable // For @Composable annotation
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDirection // Not explicitly used but might be needed
import com.example.log.com.example.log.com.example.log.Button

// This import might be needed depending on your implementation of Product class
// import kotlinx.serialization.Serializable // If you use data class with kotlinx.serialization


@Composable
fun ProductManagementScreen(
    products: List<Product>,
    onAddProduct: (Product) -> Unit,
    onUpdateProduct: (Product) -> Unit,
    onDeleteProduct: (Product) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16)
    ) {
        // Thanh tiêu đề
        Text(text = "Quản lý sản phẩm", style = MaterialTheme.typography)
        Spacer(modifier = Modifier.height(16))

        // Danh sách sản phẩm
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8)
        ) {
            items(products) { product ->
                ProductItem(
                    product = product,
                    onEditProduct = { onUpdateProduct(product) },
                    onDeleteProduct = { onDeleteProduct(product) }
                )
            }
        }

        // Nút thêm sản phẩm
        Spacer(modifier = Modifier.weight(1f)) // Đẩy nút xuống cuối màn hình
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16),
            horizontalArrangement = Arrangement.End
        ) {
            Button(onClick = { /* Mở màn hình thêm sản phẩm */ }) {
                Text("Thêm sản phẩm")
            }
        }
    }
}

@Composable
fun ProductItem(
    product: Product,
    onEditProduct: () -> Unit,
    onDeleteProduct: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onEditProduct() },
        elevation = 2
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16)
        ) {
            Text(text = product.name, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = onDeleteProduct) {
                Icon(Icons.Outlined.Delete, contentDescription = "Xóa")
            }
        }
    }
}

data class Product(
    val id: Int,
    val name: String,
    val price: Int,
    val type: String
)
