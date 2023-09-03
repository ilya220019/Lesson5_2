package com.example.lesson5_2.onBoarding.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.lesson5_2.databinding.ItemOnBoardingBinding
import com.example.lesson5_2.model.onBoarding.OnBoarding


class OnBoardingAdapter (private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf(
        OnBoarding(
            "To-do list!",
            "Here you can write down something important or make a schedule for tomorrow:)",
            "data:image/jpeg;base64,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"
        ),
        OnBoarding(
            "Share your crazy idea ^_^",
            "You can easily share with your report, list or schedule and it's convenient",
            "data:image/jpeg;base64,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"
        ),
        OnBoarding(
            "Flexibility",
            "Your note with you at home, at work, even at the resort",
            "data:image/jpeg;base64,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"
        ),
        OnBoarding(
            "Flexibility",
            "Your note with you at home, at work, even at the resort",
            "data:image/jpeg;base64,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"
        )
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