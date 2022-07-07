package com.example.educationalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.educationalproject.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    lateinit var bindingClass : FragmentDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingClass = FragmentDetailsBinding.bind(view)

        val film = arguments?.get("film") as Film

        bindingClass.detailsToolbar.title = film.title
        bindingClass.detailsPoster.setImageResource(film.poster)
        bindingClass.detailsDescription.text = film.description
    }
}