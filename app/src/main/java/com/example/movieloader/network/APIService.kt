package com.example.movieloader.network

import com.example.movieloader.model.CharacterItem
import com.example.movieloader.model.Response
import com.example.movieloader.utils.Constants
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface APIService {
    @GET(Constants.END_POINTS)
    suspend fun getCharacters(
    ): Response

}