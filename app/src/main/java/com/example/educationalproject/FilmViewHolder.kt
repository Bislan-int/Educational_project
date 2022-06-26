package com.example.educationalproject

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.educationalproject.databinding.FilmItemBinding

class FilmViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding = FilmItemBinding.bind(itemView)

    private val title = binding.title
    private val poster = binding.poster
    private val description = binding.description

    fun bind(film: Film) {
        title.text = film.title
        poster.setImageResource(film.poster)
        description.text = film.description
    }
}