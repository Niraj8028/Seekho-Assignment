package com.example.seekhoassignment.Repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.seekhoassignment.API.AnimeApi
import com.example.seekhoassignment.Model.Animes
import javax.inject.Inject

class AnimeRepository @Inject constructor(val animeApi: AnimeApi) {
    private val _animes = MutableLiveData<List<Animes>>()
    val animes get() = _animes

    suspend fun getTopRatedMovies() {
        val response = animeApi.getPopularAnime();
        Log.d("Response", response.toString())
        if(response.isSuccessful && response.body() != null){
            Log.d("API response", response.body().toString())
            val animeResponse = response.body();
            _animes.postValue(animeResponse?.data)
        } else {
            Log.d("API response", "Error")
        }
    }
}