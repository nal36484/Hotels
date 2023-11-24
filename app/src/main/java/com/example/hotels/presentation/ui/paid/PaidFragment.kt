package com.example.hotels.presentation.ui.paid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hotels.R
import com.example.hotels.databinding.FragmentPaidBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PaidFragment : Fragment() {

    private var _binding: FragmentPaidBinding? = null
    private val binding get() = _binding!!
    private val paidViewModel: PaidViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        paidViewModel.getData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaidBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachListeners()
    }

    private fun attachListeners() {
        binding.navigationBar.arrowBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.bottomBar.toStart.setOnClickListener {
            findNavController().navigate(R.id.action_paidFragment_to_hotelFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}