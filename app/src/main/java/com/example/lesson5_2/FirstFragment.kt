package com.example.lesson5_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lesson5_2.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()

    }

    private fun initClicker() {
        with(binding) {
            btnCalculate.setOnClickListener {
                findNavController().navigate(
                    R.id.detailFragment, bundleOf(
                        "Key" to
                                binding.etFirst.text.toString(),
                        "key2" to
                                binding.etSecond.text.toString()
                    )
                )
            }

        }
    }
}