package com.example.lesson5_2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lesson5_2.App
import com.example.lesson5_2.Presenter
import com.example.lesson5_2.R
import com.example.lesson5_2.databinding.FragmentFirstBinding
import com.example.lesson5_2.model.LoveModel
import com.example.lesson5_2.view.LoveView


class FirstFragment : Fragment(), LoveView {
    private lateinit var binding: FragmentFirstBinding
    private val presenter = Presenter(this)
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
                presenter.getLoveResult(etFirst.text.toString(), etSecond.text.toString())
            }

        }
    }

    override fun navigationToResultScreen(loveModel: LoveModel) {
        App.appDatabase.loveDao().insert(loveModel)
        findNavController().navigate(R.id.detailFragment, bundleOf("key" to loveModel))
    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()    }
}