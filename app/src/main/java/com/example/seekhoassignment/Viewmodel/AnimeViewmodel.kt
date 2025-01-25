package com.example.seekhoassignment.Viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seekhoassignment.Model.Animes
import com.example.seekhoassignment.Repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AnimeViewmodel @Inject constructor(private val repository: AnimeRepository): ViewModel() {
    val animes: LiveData<List<Animes>> = repository.animes;


     fun getTopRatedAnimes(){
        viewModelScope.launch(Dispatchers.IO) {
                repository.getTopRatedMovies()
        }
    }
}