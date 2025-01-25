package com.example.seekhoassignment.Model

data class AnimeResponse(
    val pagination: Pagination,
    val data: List<Animes>
)
data class Pagination(
    val lastVisiblePage: Int,
    val hasNextPage: Boolean,
    val currentPage: Int,
    val items: PaginationItems
)

data class PaginationItems(
    val count: Int,
    val total: Int,
    val perPage: Int
)
data class Animes(
    val episodes: Int,
    val images: Images,
    val score: Double,
    val title: String
)

data class Images(
    val webp: Webp
)

data class Webp(
    val image_url: String,
    val large_image_url: String,
    val small_image_url: String
)