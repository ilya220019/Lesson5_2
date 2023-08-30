package com.example.lesson5_2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson5_2.App
import com.example.lesson5_2.R
import com.example.lesson5_2.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()

    }

    private fun setupUi() {
        val list = App.appDatabase.loveDao().getAll()

        list.forEach{

            binding.tvHistory.append("${it.firstName}\n ${it.secondName}\n ${it.percentage}\n${it.result}\n---------------\n"
            )

        }


    }

}