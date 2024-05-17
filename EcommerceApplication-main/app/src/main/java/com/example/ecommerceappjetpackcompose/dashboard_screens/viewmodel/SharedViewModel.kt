package com.example.ecommerceappjetpackcompose.dashboard_screens.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.ecommerceappjetpackcompose.R
import com.example.ecommerceappjetpackcompose.dashboard_screens.tab_screens.ProductDetails

class SharedViewModel:ViewModel() {

    val productDetailsList = listOf<ProductDetails>(
        ProductDetails(
            name = "Zeb-MAX",
            details = "ZEBRONICS Zeb-MAX Play Windows Compatible 2.4GHz Wireless Gamepad with 10H* Backup, Turbo Mode, Dual Vibration Motors, Quad Front triggers, Type C Rechargeable and Plug & Play Setup",
            price = 1070,
            image = R.drawable.zebmax,
            trending = "Trending Now"
        ),
        ProductDetails(
            name = "Redgear Pro Wireless",
            details = "Redgear Pro Wireless Gamepad with 2.4GHz Wireless Technology, Integrated Dual Intensity Motor, Illuminated Keys for PC(Compatible with Windows 7/8/8.1/10 only)",
            price = 1299,
            image = R.drawable.redgear,
            trending = "Best Selling"
        ),
        ProductDetails(
            name = "Cosmic Byte C1070T",
            details = "ZEBRONICS Zeb-MAX Play Windows Compatible 2.4GHz Wireless Gamepad with 10H* Backup, Turbo Mode, Dual Vibration Motors, Quad Front triggers, Type C Rechargeable and Plug & Play Setup",
            price = 1419,
            image = R.drawable.cosmic,
            trending = "Best Selling"
        ),
        ProductDetails(
            name = "RPM Euro Games",
            details = "Eccentric 360 and #x2DA\n" +
                    "Double triggers and analog bumpers, 1 Year Warranty\n" +
                    "analog sticks for more comfort,Ultra-precise eight-way D Cross\n" +
                    "Integrated Dual Mode: X-input and Direct-input for greater games compatibility\n" +
                    "Dongle should be directly in sight of controller",
            price = 898,
            image = R.drawable.rpm,
            trending = "Trending Now"
        ),
        ProductDetails(
            name = "Cosmic Byte C3070W",
            details = "Cosmic Byte C3070W Nebula 2.4G Wireless Gamepad for PC/PS3 supports Windows XP/7/8/10, Rubberized Texture (Camo Red)",
            price = 1499,
            image = R.drawable.nebula,
            trending = "Trending Now"
        ),
        ProductDetails(
            name = "Ant Esports GP310",
            details = "Compatibility – PC / Laptop Computer(Windows 10/8/7/XP), Steam, Play Station 3(PS3), Android Mobile Phone*/Tablet*/the device needs support OTG function( * not all Android phones are supported, check your device before purchasing for Android devices, Limited games can play on it which are supported to android games)\n" +
                    "Excellent Design – Equipped with 2.4Ghz wireless technology, supports up to 10m range | Wear-resistant Anti-slip Joystick | Cool Appearance | Comfortable Grip\n" +
                    "Plug & Play -Only for PC games supporting X input mode, Android mobile games supporting Android mode, Play Station 3. No need to install drivers except for Windows XP",
            price = 1299,
            image = R.drawable.antesprot,
            trending = "Trending"
        ),
        ProductDetails(
            name = "Logitech G F710",
            details = "2.4 GHZ WIRELESS CONNECTION - Plug and forget. Cut the cord and enjoy the freedom—gaming without wires. Simply insert the nano-receiver into a USB port for fast, 2.4 GHz data transmission with virtually no delays, dropouts or interference\n" +
                    "WORKS WITH ANDROID TV - Our game controllers work with Sony Android TVs. With the controller switch in XID mode, our console-like layout will give you the edge as you compete. Smooth curves and contoured rubber grips provide comfortable play sessions\n" +
                    "EXTENSIVE GAME SUPPORT - Play hits and classics Play console ports with their native-style controller or adopt a more relaxed position while enjoying PC games. F710 is easy to set up and use with your favorite games thanks to XInput/DirectInput—the two most common input standards",
            price = 3395,
            image = R.drawable.logi,
            trending = "Best Selling"
        ),
        ProductDetails(
            name = "RPM Euro Games",
            details = "Eccentric 360 and #x2DA\n" +
                    "Double triggers and analog bumpers, 1 Year Warranty\n" +
                    "analog sticks for more comfort,Ultra-precise eight-way D Cross\n" +
                    "Integrated Dual Mode: X-input and Direct-input for greater games compatibility\n" +
                    "Dongle should be directly in sight of controller",
            price = 898,
            image = R.drawable.rpm,
            trending = "Trending Now"
        ),
        ProductDetails(
            name = "Zeb-MAX2",
            details = "ZEBRONICS Zeb-MAX Play Windows Compatible 2.4GHz Wireless Gamepad with 10H* Backup, Turbo Mode, Dual Vibration Motors, Quad Front triggers, Type C Rechargeable and Plug & Play Setup",
            price = 1070,
            image = R.drawable.zebmax,
            trending = "Trending Now"
        ),
        ProductDetails(
            name = "Redgear Pro Wireless2",
            details = "Redgear Pro Wireless Gamepad with 2.4GHz Wireless Technology, Integrated Dual Intensity Motor, Illuminated Keys for PC(Compatible with Windows 7/8/8.1/10 only)",
            price = 1299,
            image = R.drawable.redgear,
            trending = "Best Selling"
        ),
        ProductDetails(
            name = "Cosmic Byte C1070T2",
            details = "ZEBRONICS Zeb-MAX Play Windows Compatible 2.4GHz Wireless Gamepad with 10H* Backup, Turbo Mode, Dual Vibration Motors, Quad Front triggers, Type C Rechargeable and Plug & Play Setup",
            price = 1419,
            image = R.drawable.cosmic,
            trending = "Best Selling"
        ),
        ProductDetails(
            name = "RPM Euro Games2",
            details = "Eccentric 360 and #x2DA\n" +
                    "Double triggers and analog bumpers, 1 Year Warranty\n" +
                    "analog sticks for more comfort,Ultra-precise eight-way D Cross\n" +
                    "Integrated Dual Mode: X-input and Direct-input for greater games compatibility\n" +
                    "Dongle should be directly in sight of controller",
            price = 898,
            image = R.drawable.rpm,
            trending = "Trending Now"
        ),
        ProductDetails(
            name = "Cosmic Byte C3070W2",
            details = "Cosmic Byte C3070W Nebula 2.4G Wireless Gamepad for PC/PS3 supports Windows XP/7/8/10, Rubberized Texture (Camo Red)",
            price = 1499,
            image = R.drawable.nebula,
            trending = "Trending Now"
        ),
        ProductDetails(
            name = "Ant Esports GP3102",
            details = "Compatibility – PC / Laptop Computer(Windows 10/8/7/XP), Steam, Play Station 3(PS3), Android Mobile Phone*/Tablet*/the device needs support OTG function( * not all Android phones are supported, check your device before purchasing for Android devices, Limited games can play on it which are supported to android games)\n" +
                    "Excellent Design – Equipped with 2.4Ghz wireless technology, supports up to 10m range | Wear-resistant Anti-slip Joystick | Cool Appearance | Comfortable Grip\n" +
                    "Plug & Play -Only for PC games supporting X input mode, Android mobile games supporting Android mode, Play Station 3. No need to install drivers except for Windows XP",
            price = 1299,
            image = R.drawable.antesprot,
            trending = "Trending"
        ),
        ProductDetails(
            name = "Logitech G F7102",
            details = "2.4 GHZ WIRELESS CONNECTION - Plug and forget. Cut the cord and enjoy the freedom—gaming without wires. Simply insert the nano-receiver into a USB port for fast, 2.4 GHz data transmission with virtually no delays, dropouts or interference\n" +
                    "WORKS WITH ANDROID TV - Our game controllers work with Sony Android TVs. With the controller switch in XID mode, our console-like layout will give you the edge as you compete. Smooth curves and contoured rubber grips provide comfortable play sessions\n" +
                    "EXTENSIVE GAME SUPPORT - Play hits and classics Play console ports with their native-style controller or adopt a more relaxed position while enjoying PC games. F710 is easy to set up and use with your favorite games thanks to XInput/DirectInput—the two most common input standards",
            price = 3395,
            image = R.drawable.logi,
            trending = "Best Selling"
        ),
        ProductDetails(
            name = "RPM Euro Games2",
            details = "Eccentric 360 and #x2DA\n" +
                    "Double triggers and analog bumpers, 1 Year Warranty\n" +
                    "analog sticks for more comfort,Ultra-precise eight-way D Cross\n" +
                    "Integrated Dual Mode: X-input and Direct-input for greater games compatibility\n" +
                    "Dongle should be directly in sight of controller",
            price = 898,
            image = R.drawable.rpm,
            trending = "Trending Now"
        ),
        ProductDetails(
            name = "Cosmic Byte C3070W2",
            details = "Cosmic Byte C3070W Nebula 2.4G Wireless Gamepad for PC/PS3 supports Windows XP/7/8/10, Rubberized Texture (Camo Red)",
            price = 1499,
            image = R.drawable.nebula,
            trending = "Trending Now"
        ),
        ProductDetails(
            name = "Ant Esports GP3102",
            details = "Compatibility – PC / Laptop Computer(Windows 10/8/7/XP), Steam, Play Station 3(PS3), Android Mobile Phone*/Tablet*/the device needs support OTG function( * not all Android phones are supported, check your device before purchasing for Android devices, Limited games can play on it which are supported to android games)\n" +
                    "Excellent Design – Equipped with 2.4Ghz wireless technology, supports up to 10m range | Wear-resistant Anti-slip Joystick | Cool Appearance | Comfortable Grip\n" +
                    "Plug & Play -Only for PC games supporting X input mode, Android mobile games supporting Android mode, Play Station 3. No need to install drivers except for Windows XP",
            price = 1299,
            image = R.drawable.antesprot,
            trending = "Trending"
        ),
        ProductDetails(
            name = "Logitech G F7103",
            details = "2.4 GHZ WIRELESS CONNECTION - Plug and forget. Cut the cord and enjoy the freedom—gaming without wires. Simply insert the nano-receiver into a USB port for fast, 2.4 GHz data transmission with virtually no delays, dropouts or interference\n" +
                    "WORKS WITH ANDROID TV - Our game controllers work with Sony Android TVs. With the controller switch in XID mode, our console-like layout will give you the edge as you compete. Smooth curves and contoured rubber grips provide comfortable play sessions\n" +
                    "EXTENSIVE GAME SUPPORT - Play hits and classics Play console ports with their native-style controller or adopt a more relaxed position while enjoying PC games. F710 is easy to set up and use with your favorite games thanks to XInput/DirectInput—the two most common input standards",
            price = 3395,
            image = R.drawable.logi,
            trending = "Best Selling"
        ),
        ProductDetails(
            name = "RPM Euro Games3",
            details = "Eccentric 360 and #x2DA\n" +
                    "Double triggers and analog bumpers, 1 Year Warranty\n" +
                    "analog sticks for more comfort,Ultra-precise eight-way D Cross\n" +
                    "Integrated Dual Mode: X-input and Direct-input for greater games compatibility\n" +
                    "Dongle should be directly in sight of controller",
            price = 898,
            image = R.drawable.rpm,
            trending = "Trending Now"
        ),
    )

    var selectedProduct :ProductDetails = productDetailsList.first()

    val favoriteProducts = mutableStateListOf<ProductDetails>()

    val cartProducts = mutableStateListOf<ProductDetails>()

    val historyProducts = mutableStateListOf<ProductDetails>()
}