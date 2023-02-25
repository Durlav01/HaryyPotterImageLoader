package com.example.movieloader.screen

import com.example.movieloader.model.CharacterItem

data class CharacterStateHolder(


    val isLoading : Boolean = false,
    val data: List<CharacterItem>?= null,
    val error : String =""
)
