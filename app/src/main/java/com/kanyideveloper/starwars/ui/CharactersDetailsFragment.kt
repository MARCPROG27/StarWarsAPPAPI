package com.kanyideveloper.starwars.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.kanyideveloper.starwars.databinding.FragmentCharactersDetailsBinding
import com.kanyideveloper.starwars.utils.Resource
import com.kanyideveloper.starwars.viewmodels.CharacterDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class CharactersDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCharactersDetailsBinding
    private val viewModel: CharacterDetailsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel.details.observe(viewLifecycleOwner, Observer { result ->
            binding.textViewFullNameValue.text = result.name
            binding.textViewSkinColorValue.text = result.skinColor
            binding.textViewHairColorValue.text = result.hairColor
            binding.textViewHeightValue.text = result.height
            binding.textViewMassValue.text = result.mass
            binding.textViewEyeColorValue.text = result.eyeColor
            binding.textViewGenderValue.text = result.gender
            binding.textViewBirthYearValue.text = result.birthYear
        })

        return view
    }
}