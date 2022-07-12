package com.example.educationalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.educationalproject.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {
    lateinit var bindingClass : FragmentFavoritesBinding
    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingClass = FragmentFavoritesBinding.bind(view)
        val favoritesList: List<Film> = emptyList()

        bindingClass.favoritesRecycler
            .apply {
                filmsAdapter =
                    FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                        override fun click(film: Film) {
                            (requireActivity() as MainActivity).launchDetailsFragment(film)
                        }
                    })
                adapter = filmsAdapter
                layoutManager = LinearLayoutManager(requireContext())
                val decorator = TopSpacingItemDecoration(8)
                addItemDecoration(decorator)
            }
        filmsAdapter.addItems(favoritesList)
    }

}