package com.slivtis.tienda.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.slivtis.maderas.ui.view.components.TopAppBarProduct
import com.slivtis.tienda.R
import com.slivtis.tienda.ui.theme.Brown80
import com.slivtis.tienda.ui.theme.Divider500
import com.slivtis.tienda.ui.theme.TiendaTheme
import com.slivtis.tienda.data.models.Comment
import com.slivtis.tienda.ui.theme.body
import com.slivtis.tienda.ui.theme.titleBar
import com.slivtis.tienda.ui.theme.titleProduct
import com.slivtis.tienda.ui.viewmodel.ProductViewModel

@Composable
fun Product(viewModel: ProductViewModel, navController: NavController) {
    TiendaTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TopAppBarProduct(title = "Tienda",
                onNavigation = { navController.popBackStack() },
                onShoppin = {},
                onFavorite = {},
                contentScreen = { ContentProduct(viewModel) }
            )
        }
    }
}

@Composable
fun ContentProduct(viewModel: ProductViewModel) {
    val comments by viewModel.comments.observeAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 30.dp, vertical = 20.dp)
            .verticalScroll(rememberScrollState())
    ) {

        //Section Image
        SectionImage("Blusa")

        //Section selected Color picker

        //Section selected size

        //Section Shipping
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            color = Divider500,
        )
        SectionShipping()

        //Section details
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            color = Divider500,
        )
        SectionDescription()

        //Button add
        Spacer(modifier = Modifier.height(20.dp))
        ButtonAddCart {

        }
        //Comments
        Text(modifier = Modifier.padding(top = 20.dp),text= "Comentarios", style = MaterialTheme.typography.titleBar, fontSize = 16.sp)
        CommentSection(comments = comments)
        //Section recommended
    }
}

@Composable
fun SectionImage(Title: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.woman_conjunct_1),
            contentDescription = "Image product",
            modifier = Modifier
                .sizeIn(minHeight = 100.dp, maxHeight = 400.dp)
                .aspectRatio(1f), // Mantener la proporción original de la imagen
            contentScale = ContentScale.Fit // Escalar la imagen para ajustar el tamaño

        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "Blusa de tirantes verano", style = MaterialTheme.typography.titleProduct)
    }
}

@Composable
fun SectionShipping() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Envío", style = MaterialTheme.typography.titleBar, fontSize = 15.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Column {
            Row {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Mark favorite article",
                    tint = Brown80
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text("Envío gratuito a partir de $300", style = MaterialTheme.typography.body)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Entrega estimada 18/03/2024 - 22/03/2024",
                        style = MaterialTheme.typography.body
                    )
                }

            }
        }
    }
}

@Composable
fun SectionDescription() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Descripción", style = MaterialTheme.typography.titleBar, fontSize = 15.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Column {
            Text(text = "¡Añade un toque fresco y elegante a tu guardarropa de verano con nuestra blusa blanca de tirantes! Confeccionada con tejidos ligeros y transpirables, esta blusa es la opción ideal para los días soleados y las noches cálidas de la temporada.",
                style = MaterialTheme.typography.body)
        }
    }
}

@Composable
fun ButtonAddCart(
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Row{
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Mark favorite article",
                tint = Brown80
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "AGREGAR AL CARRITO",
                style = MaterialTheme.typography.titleBar,
            )
        }

    }
}

// Componente de la lista de comentarios
@Composable
fun CommentSection(comments: List<Comment>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        for (comment in comments) {
            item {
                CommentItem(comment = comment)
            }
        }
    }
}

@Preview
@Composable
fun CommentSectionPreview() {
    val comments = listOf(
        Comment(
            userId = "1",
            userName = "Usuario1",
            comment = "Este es un comentario de ejemplo.",
            userProfileImage = R.drawable.woman_conjunct_2
        ),
        Comment(
            userId = "2",
            userName = "Usuario2",
            comment = "Este es otro comentario de ejemplo.",
            userProfileImage = R.drawable.woman_conjunct_1
        )
    )
    CommentSection(comments = comments)
}

@Composable
fun CommentItem(comment: Comment) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = comment.userProfileImage),
            contentDescription = "User profile image",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = comment.userName,
                style = MaterialTheme.typography.titleBar,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = comment.comment,
                style = MaterialTheme.typography.body,
                color = Brown80,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}