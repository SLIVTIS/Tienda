package com.slivtis.tienda.data.repository

import com.slivtis.tienda.R
import com.slivtis.tienda.data.models.Comment
import javax.inject.Inject

class ProductRepository @Inject constructor(
) {

    fun getComments(): List<Comment> {
        val comments = listOf(
            Comment(
                userId = "1",
                userName = "Danna G.",
                comment = "Este es un comentario de ejemplo.",
                userProfileImage = R.drawable.woman_conjunct_2
            ),
            Comment(
                userId = "2",
                userName = "Paola M.",
                comment = "Este es otro comentario de ejemplo.",
                userProfileImage = R.drawable.woman_conjunct_1
            )
        )
        return comments
    }
}