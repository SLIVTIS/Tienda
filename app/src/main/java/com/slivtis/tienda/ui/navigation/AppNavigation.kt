package com.slivtis.maderas.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.slivtis.tienda.ui.view.Product
import com.slivtis.tienda.ui.viewmodel.ProductViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.ProductScreen.route) {
        composable(route = AppScreens.ProductScreen.route) {
            val viewModel = hiltViewModel<ProductViewModel>()
            Product(viewModel = viewModel,navController = navController)
        }
    }
}