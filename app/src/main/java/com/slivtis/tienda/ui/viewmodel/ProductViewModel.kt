package com.slivtis.tienda.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.slivtis.tienda.data.models.Comment
import com.slivtis.tienda.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {
    private val _comments = MutableLiveData<List<Comment>>()
    val comments: LiveData<List<Comment>> = _comments

    init {
        _comments.value = productRepository.getComments()
    }
}