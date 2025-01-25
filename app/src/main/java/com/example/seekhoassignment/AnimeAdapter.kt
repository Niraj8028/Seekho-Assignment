package com.example.seekhoassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.seekhoassignment.Model.Animes

class AnimeAdapter(
    private val animeList: List<Animes>
) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    // ViewHolder for individual list items
    class AnimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val animeImage: ImageView = view.findViewById(R.id.animePoster)
        val animeTitle: TextView = view.findViewById(R.id.animeTitle)
        val animeEpisodes: TextView = view.findViewById(R.id.episodes)
        val animeScore: TextView = view.findViewById(R.id.ratings)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_anime, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val anime = animeList[position]
        holder.animeTitle.text = anime.title
        holder.animeEpisodes.text = "Episodes: ${anime.episodes}"
        holder.animeScore.text = "Rating: ${anime.score}"

        // Use Glide or another library to load images
        Glide.with(holder.animeImage.context)
            .load(anime.images.webp.image_url) // Use small_image_url if needed
            .into(holder.animeImage)
    }

    override fun getItemCount(): Int = animeList.size
}
