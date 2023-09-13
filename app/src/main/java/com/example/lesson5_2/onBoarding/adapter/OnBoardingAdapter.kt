package com.example.lesson5_2.onBoarding.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.lesson5_2.R
import com.example.lesson5_2.databinding.ItemOnBoardingBinding
import com.example.lesson5_2.model.onBoarding.OnBoarding


class OnBoardingAdapter (private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf(
        OnBoarding(
            "To-do list!",
            "Here you can write down something important or make a schedule for tomorrow:)",
            R.raw.animation_lmgdsbop
        ),
        OnBoarding(
            "Share your crazy idea ^_^",
            "You can easily share with your report, list or schedule and it's convenient",
            R.raw.animation_lmgdtfrc        ),
        OnBoarding(
            "Flexibility",
            "Your note with you at home, at work, even at the resort",
            R.raw.animation_lmgdtx62      ),
        OnBoarding(
            "Flexibility",
            "Your note with you at home, at work, even at the resort",
R.raw.animation_lmgdu1hr        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) {
            binding.tvTitle.text = onBoarding.title
            binding.tvDesc.text = onBoarding.desc
            Glide.with(binding.ivBoard).load(onBoarding.image).into(binding.ivBoard)
            binding.btnStart.isVisible = adapterPosition == data.lastIndex
            binding.skip.isVisible = adapterPosition != data.lastIndex
            binding.btnStart.setOnClickListener {
                onClick()

            }
            binding.skip.setOnClickListener {

                onClick()

            }
        }
    }
}