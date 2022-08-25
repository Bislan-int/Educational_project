package com.example.educationalproject.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.educationalproject.R
import com.example.educationalproject.databinding.FragmentDetailsBinding
import com.example.educationalproject.domain.Film

class DetailsFragment : Fragment() {
    lateinit var bindingClass : FragmentDetailsBinding
    private lateinit var film: Film

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingClass = FragmentDetailsBinding.bind(view)
        film = arguments?.get("film") as Film

        bindingClass.detailsToolbar.title = film.title
        bindingClass.detailsPoster.setImageResource(film.poster)
        bindingClass.detailsDescription.text = film.description


        bindingClass.detailsFabFavorites.setImageResource(
            if (film.isInFavorites) R.drawable.ic_baseline_favorite
            else R.drawable.ic_baseline_favorite_border_24
        )

        bindingClass.detailsFabFavorites.setOnClickListener {
            if (!film.isInFavorites) {
                bindingClass.detailsFabFavorites.setImageResource(R.drawable.ic_baseline_favorite)
                film.isInFavorites = true
            } else {
                bindingClass.detailsFabFavorites.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                film.isInFavorites = false
            }
        }

        bindingClass.detailsFab.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Check out this film: ${film.title} \n\n ${film.description}"
            )
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share To:"))
        }
    }
}