package com.slivtis.maderas.ui.view.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
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

@Preview
@Composable
fun view(){
    TopAppBar (title = "Prueba", contentScreen = { Column(modifier = Modifier.fillMaxSize()){
        Text(text = "Hola")
        Text(text = "Hola 2")
        Text(text = "Hola 3")
        Text(text = "Hola 4")
    } })

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    primaryColor: Color = Color.White,
    secundaryColor: Color = Color.Black,
    title: String = "",
    contentScreen: @Composable (() -> Unit)? = null,
    onActions: (() -> Unit)? = null,
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
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                navigationIcon = {
                    onNavigation?.let {
                        IconButton(onClick = {onNavigation() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Localized description",
                                tint = secundaryColor
                            )
                        }
                    }
                },
                actions = {
                    onActions?.let {
                        IconButton(onClick = { onActions() }) {
                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = "Localized description",
                                tint = secundaryColor
                            )
                        }
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { innerPadding ->
        contentScreen?.let {
            Box(modifier = Modifier.padding(innerPadding)){
                contentScreen()
            }
        }
    }
}