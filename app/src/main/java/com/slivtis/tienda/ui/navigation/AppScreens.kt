package com.slivtis.maderas.ui.navigation

sealed class AppScreens(val route: String){
    object ProductScreen: AppScreens("product_screen")
}
