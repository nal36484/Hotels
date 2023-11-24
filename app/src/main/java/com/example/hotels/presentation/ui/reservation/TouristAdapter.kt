package com.example.hotels.presentation.ui.reservation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hotels.R
import com.example.hotels.databinding.TouristRecyclerElementBinding
import com.example.hotels.presentation.ui.reservation.models.Tourist

class TouristAdapter : RecyclerView.Adapter<TouristAdapter.TouristViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TouristAdapter.TouristViewHolder {
        val binding = TouristRecyclerElementBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TouristViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TouristAdapter.TouristViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    class TouristViewHolder(private val binding: TouristRecyclerElementBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tourist: Tourist) {
            //for example
            binding.apply {
                topBar.numberOfTourist.text = setTouristNumber(tourist.id)
                topBar.arrow.setOnClickListener {
                    val visibility = binding.form.root.isVisible
                    binding.form.root.isVisible = !visibility
                    if (visibility) {
                        binding.topBar.arrow.setImageResource(R.drawable.arrow_bot)
                    } else {
                        binding.topBar.arrow.setImageResource(R.drawable.arrow_top)
                    }
                }
                form.apply {
                    nameEditor.setText(tourist.name)
                    surnameEditor.setText(tourist.surname)
                }
            }
        }

        private fun setTouristNumber(id: Int): CharSequence {
            return when(id) {
                1 -> "Первый турист"
                2 -> "Второй турист"
                3 -> "Третий турист"
                4 -> "Четвёртый турист"
                5 -> "Пятый турист"
                else -> "Первый турист"
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Tourist>() {
        override fun areItemsTheSame(oldItem: Tourist, newItem: Tourist): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Tourist, newItem: Tourist): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
}