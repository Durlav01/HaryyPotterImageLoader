package com.example.movieloader.screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieloader.data.Resource
import com.example.movieloader.repo.CharacterRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CharacterViewModel @Inject constructor(private val repo: CharacterRepo): ViewModel() {


    val characterList= mutableStateOf(CharacterStateHolder())


init {
    characterList.value= CharacterStateHolder(isLoading = true)
    getCharacter()
}



    private fun getCharacter()=viewModelScope.launch(Dispatchers.IO) {

        when(val result =repo.getCharacter()){

            is Resource.Success ->{
                characterList.value = CharacterStateHolder(data = result.data)
            }

            is Resource.Error ->{
                characterList.value= CharacterStateHolder(error = result.message.toString())
            }

            else ->{

            }
        }


    }




}