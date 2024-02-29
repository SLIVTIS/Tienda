package com.slivtis.maderas.ui.view.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.slivtis.tienda.ui.theme.Brown80
import com.slivtis.tienda.ui.theme.PinkLight400
import com.slivtis.tienda.ui.theme.titleBar
import com.slivtis.tienda.ui.view.SectionImage

@Preview
@Composable
fun viewa() {
    TopAppBarProduct(title = "", onNavigation ={}, contentScreen = {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "Hola")
            Text(text = "Hola 2")
            Text(text = "Hola 3")
            Text(text = "Hola 4")
        }
    })

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarProduct(
    primaryColor: Color = PinkLight400,
    secundaryColor: Color = Brown80,
    title: String = "",
    contentScreen: @Composable (() -> Unit)? = null,
    onShoppin: (() -> Unit)? = null,
    onFavorite: (()-> Unit)? = null,
    onNavigation: (() -> Unit)? = null
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = primaryColor,
                    titleContentColor = secundaryColor,
                ),
                title = {
                    Text(
                        title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleBar
                    )
                },
                navigationIcon = {
                    onNavigation?.let {
                        IconButton(onClick = { onNavigation() }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Exit article",
                                tint = Brown80
                            )
                        }
                    }
                },
                actions = {
                    IconButton(onClick = {
                        if (onShoppin != null) {
                            onShoppin()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Shoppin cart",
                            tint = Brown80
                        )
                    }
                    IconButton(onClick = {
                        if (onFavorite != null) {
                            onFavorite()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Mark favorite article",
                            tint = Brown80
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { innerPadding ->
        contentScreen?.let {
            Box(modifier = Modifier
                .padding(innerPadding)) {
                contentScreen()
            }
        }
    }
}