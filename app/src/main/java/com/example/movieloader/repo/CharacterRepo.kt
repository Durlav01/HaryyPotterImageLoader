package com.example.movieloader.repo

import com.example.movieloader.data.Resource
import com.example.movieloader.model.CharacterItem
import com.example.movieloader.network.APIService
import javax.inject.Inject

class CharacterRepo @Inject constructor(private val api: APIService) {

    suspend fun getCharacter(): Resource<List<CharacterItem>>{

        return try {
            Resource.Success(data = api.getCharacters())
        }
        catch (e: Exception){
            Resource.Error(message = e.message.toString())
        }


    }

}