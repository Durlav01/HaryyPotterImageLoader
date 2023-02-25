package com.example.movieloader.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.movieloader.model.CharacterItem


@Composable

fun characterListScreen(viewModel: CharacterViewModel= hiltViewModel()){
    
    val result = viewModel.characterList.value
    
    
    if(result.isLoading){

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()

        }
    }
    if (result.error.isNotBlank()){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = result.error)
        }
    }
    
    result.data?.let { 
        
        LazyColumn{
            items(result.data){
                CharacterItemScreen(it)
            }
        }
    }
    
}

@Composable
fun CharacterItemScreen(it: CharacterItem) {
        
    
    AsyncImage(model = it.image, contentDescription = null,modifier = Modifier.fillMaxWidth().height(500.dp).padding(vertical = 8.dp), contentScale = ContentScale.Crop)
}
