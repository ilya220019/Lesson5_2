package com.example.lesson5_2.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson5_2.ResultPresenter
import com.example.lesson5_2.databinding.FragmentDetailBinding
import com.example.lesson5_2.model.LoveModel
import com.example.lesson5_2.model.RetrofitService
import com.example.lesson5_2.view.ResultView
import retrofit2.Call
import retrofit2.Response

class DetailFragment : Fragment(), ResultView {

    private lateinit var binding: FragmentDetailBinding
    private val presenter = ResultPresenter(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
    }

    private fun setupUi() {
        val result = arguments?.getSerializable("key") as LoveModel
        presenter.getData(result)
    }

    override fun showLove(
        firstName: String,
        secondName: String,
        percentage: String,
        result: String
    ) {
        with(binding) {
            binding.tv1.text = firstName
            binding.tv2.text = secondName
            binding.tv3.text = result
            binding.tv4.text = percentage

        }
    }
}