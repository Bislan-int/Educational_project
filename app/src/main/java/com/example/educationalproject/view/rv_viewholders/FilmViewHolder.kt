package com.example.educationalproject.view.rv_viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.educationalproject.databinding.FilmItemBinding
import com.example.educationalproject.domain.Film

class FilmViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding = FilmItemBinding.bind(itemView)

    private val title = binding.title
    private val poster = binding.poster
    private val description = binding.description
    private val ratingDonut = binding.ratingDonut

    fun bind(film: Film) {
        title.text = film.title
        poster.setImageResource(film.poster)
        description.text = film.description
        ratingDonut.setProgress((film.rating * 10).toInt())
    }
}