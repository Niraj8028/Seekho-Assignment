package com.example.seekhoassignment.API

import com.example.seekhoassignment.Model.AnimeResponse
import com.example.seekhoassignment.Model.Animes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface AnimeApi {

    @GET("top/anime")
    suspend fun getPopularAnime(): Response<AnimeResponse>

//    @GET("/anime/{animeName}")
//    suspend fun getAnimeDetails(@Path("animeName") animeName:String): Response<AnimeDetails>
}