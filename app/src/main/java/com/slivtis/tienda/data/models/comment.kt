package com.slivtis.tienda.data.models

// Modelo de comentario
data class Comment(
    val userId: String,
    val userName: String,
    val comment: String,
    val userProfileImage: Int
)