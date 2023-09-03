package com.example.lesson5_2.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lesson5_2.R
import com.example.lesson5_2.databinding.FragmentOnBoardingBinding
import com.example.lesson5_2.onBoarding.adapter.OnBoardingAdapter
import com.example.lesson5_2.preferens.Pref
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {
   private lateinit var binding: FragmentOnBoardingBinding
    private val adapter = OnBoardingAdapter(this::onClick)
    @Inject
    lateinit var pref: Pref
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewpager.adapter = adapter
    }

    private fun onClick() {
        pref.onBoardingShowed()
        findNavController().navigate(R.id.firstFragment)
    }

}