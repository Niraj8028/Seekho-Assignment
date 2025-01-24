package com.example.seekhoassignment.API

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface AnimeApi {

    @GET("/top/anime")
    suspend fun getPopularAnime(): Response<List<Anime>>

    @GET("/anime/{animeName}")
    suspend fun getAnimeDetails(@Path("animeName") animeName:String): Response<AnimeResponse>
}