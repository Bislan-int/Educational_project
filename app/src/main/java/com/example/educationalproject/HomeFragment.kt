package com.example.educationalproject

import android.os.Bundle
import android.transition.Scene
import android.transition.Slide
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.educationalproject.databinding.FragmentHomeBinding
import com.example.educationalproject.databinding.MergeHomeScreenContentBinding
import java.util.*

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding

    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    val filmsDataBase = listOf(
        Film("Moon Knight", R.drawable.moon_knight, "Steven Grant discovers he's been granted the powers of an Egyptian moon god. But he soon finds out that these newfound powers can be both a blessing and a curse to his troubled life."),
        Film("Doctor Strange", R.drawable.doctor_strange, "A terrible car accident put an end to the career of a successful neurosurgeon Doctor Strange. Desperate, he embarks on a journey in search of healing and discovers his incredible ability to transform space and time. Now he is a link between parallel dimensions, and his mission is to protect the inhabitants of the Earth and counteract Evil, no matter what form it takes."),
        Film("Black Widow", R.drawable.black_widow, "The new MARVEL blockbuster will tell the backstory of Natasha Romanoff, also known as the Black Widow, before she became one of the Avengers team."),
        Film("Shang Chi", R.drawable.shang_chi, "Martial artist Shang-Chi must confront ghosts from his own past as he is drawn into a web of intrigue by the mysterious Ten Rings organization."),
        Film("Halo", R.drawable.halo, "The action will unfold in the twenty-sixth century, where people are at war with an alliance of alien races known as the Covenant. Despite fierce resistance, humanity is losing in an unequal struggle for survival. The last hope is a program to create superhumans who must turn the tide of the war."),
        Film("Vikings: Valhalla", R.drawable.vikings, "About the exploits and adventures of the famous Vikings who lived at the beginning of the 11th century: about the legendary explorer Leif Eriksson (Sam Corlett), his quick-tempered and wayward sister Freydis Eriksdottir (Frida Gustavsson) and the ambitious Scandinavian ruler Harald Sigurdsson (Leo Suter). The tension between the Vikings and the English kings reaches a bloody denouement, and in the meantime, contradictions between Christians and pagans are growing among the Vikings themselves. During this challenging time, the series' characters embark on an epic journey across oceans and battlefields, from Kattegat to England and beyond, to survive and find glory. Vikings is set over a century after the events of the original Vikings series."),
        Film("Adam Project", R.drawable.adam, "The Adam Project is a fantasy film about a man named Adam who has the unique experience of being a pilot and able to travel through time and space. This not only makes it possible to experience a lot of adventures, but also obliges to be careful. One day, Adam has to make an emergency landing, stopping in 2022 - during this period he was 12 years old. Together with his younger version, he takes on the salvation of the future."),
        Film("Uncharted: Not on the cards", R.drawable.ancharted, "Nathan Drake hasn't seen his older brother Sam in 15 years since he ran away from the orphanage. The guy works as a bartender and trades in petty theft, when Victor Sullivan, nicknamed Sully, comes up to him and offers to go in search of the long-lost treasures of Magellan. After learning that Sally knows Sam, Nathan agrees to the adventure, hoping to also find his brother."),
        Film("DEADPOOL", R.drawable.deadpool, "Wade Wilson is a mercenary. As a by-product of the military's \"Weapon X\" program, Wilson gained incredible strength, agility, and healing abilities. But at a terrible cost: his cellular structure is constantly changing, and his sanity is questionable. All Wilson wants is to stay afloat in the social cesspool. But the current is too fast."),
        Film("The Wheel of Time", R.drawable.time, "Set in a high fantasy world where magic exists, but only some can access it, a woman named Moiraine crosses paths with five young men and women. This sparks a dangerous, world-spanning journey. Based on the book series by Robert Jordan.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AnimationHelper.performFragmentCircularRevealAnimation(binding.homeFragmentRoot, requireActivity(), 1)

        initSearchView()

        initRecyckler()
        filmsAdapter.addItems(filmsDataBase)
    }

    private fun initSearchView() {
        binding.searchView.setOnClickListener {
            binding.searchView.isIconified = false
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty()) {
                    filmsAdapter.addItems(filmsDataBase)
                    return true
                }
                val result = filmsDataBase.filter {
                    it.title.toLowerCase(Locale.getDefault()).contains(newText.toLowerCase(Locale.getDefault()))
                }
                filmsAdapter.addItems(result)
                return true
            }
        })
    }

    private fun initRecyckler() {
        binding.mainRecycler.apply {
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener{
                override fun click(film: Film) {
                    (requireActivity() as MainActivity).launchDetailsFragment(film)
                }
            })
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(requireContext())
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
    }
}