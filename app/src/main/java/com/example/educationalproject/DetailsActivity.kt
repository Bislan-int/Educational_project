package com.example.educationalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.educationalproject.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        val film = intent.extras?.get("film") as Film
        bindingClass.detailsToolbar.title = film.title
        bindingClass.detailsPoster.setImageResource(film.poster)
        bindingClass.detailsDescription.text = film.description
    }

}