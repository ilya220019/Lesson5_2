package com.example.lesson5_2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lesson5_2.databinding.FragmentDetailBinding
import retrofit2.Call
import retrofit2.Response

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         val one = arguments?.getString("Key")
         val two = arguments?.getString("key2")

        RetrofitService.api.calculateMatching(one.toString(), two.toString()

        ).enqueue(object:retrofit2.Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                val data = response.body()

                    binding.tv1.text = one.toString()
                    binding.tv2.text = two.toString()
                    binding.tv3.text = data?.result
                    binding.tv4.text = data?.percentage
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message}" )
            }

        })
}}