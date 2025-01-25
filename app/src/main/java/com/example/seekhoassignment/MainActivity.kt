package com.example.seekhoassignment

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.seekhoassignment.Viewmodel.AnimeViewmodel
import com.example.seekhoassignment.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AnimeAdapter
    private val viewModel: AnimeViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        // Observe anime list and update the adapter
        viewModel.animes.observe(this) { animeList ->
            adapter = AnimeAdapter(animeList)
            binding.animeRv.adapter = adapter
        }

        lifecycleScope.launch {
            viewModel.getTopRatedAnimes()
        }

    }

    private fun setupRecyclerView() {
        binding.animeRv.apply {
            layoutManager = GridLayoutManager(this@MainActivity,2)
            setHasFixedSize(true)
        }
    }


}