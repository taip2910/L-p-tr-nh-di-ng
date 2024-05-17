package com.example.log

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.junit.Test

import org.junit.Assert.*

composable("register") { RegisterScreen(navController) }


Column(
modifier = Modifier.fillMaxSize(),
verticalArrangement =  Arrangement.Center,
horizontalAlignment = Alignment.CenterHorizontally
) {
    Image(painter = painterResource(id = R.drawable.images), contentDescription ="Login image",
        modifier = Modifier.size(200.dp))

    Text(text = "Login", fontSize = 28.sp, fontWeight = FontWeight.Bold)

    Spacer(modifier = Modifier.height(16.dp))

    OutlinedTextField(value = "", onValueChange = {}, label = {
        Text(text = "Email")
    })

    Spacer(modifier = Modifier.height(16.dp))

    OutlinedTextField(value = "", onValueChange = {}, label = {
        Text(text = "Password")
    })

    Spacer(modifier = Modifier.height(16.dp))

    Button(onClick = { }) {
        Text(text = "Login")
    }

    Spacer(modifier = Modifier.height(32.dp))

    TextButton(onClick = {
        navController.navigate("register")
    }) {
        Text(text = "Register")
    }


}