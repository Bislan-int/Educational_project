package com.example.educationalproject.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.educationalproject.databinding.FragmentSelectionsBinding
import com.example.educationalproject.utils.AnimationHelper

class SelectionsFragment : Fragment() {
    lateinit var binding: FragmentSelectionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSelectionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AnimationHelper.performFragmentCircularRevealAnimation(binding.selectionsFragmentRoot, requireActivity(), 4)
    }

}