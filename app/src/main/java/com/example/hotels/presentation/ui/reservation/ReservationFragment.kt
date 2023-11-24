package com.example.hotels.presentation.ui.reservation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotels.R
import com.example.hotels.databinding.FragmentReservationBinding
import com.example.hotels.presentation.ui.utils.LayoutUtils
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class ReservationFragment : Fragment() {

    private lateinit var touristAdapter: TouristAdapter
    private var _binding: FragmentReservationBinding? = null
    private val binding get() = _binding!!
    private val reservationViewModel: ReservationViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        touristAdapter = TouristAdapter()

        reservationViewModel.getData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReservationBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        show()
    }

    private fun show() {
        attachListeners()
        attachObservers()
        applyAdapters()
    }

    private fun attachListeners() {
        binding.apply {
            navigationBar.arrowBack.setOnClickListener {
                findNavController().navigateUp()
            }
            bottomBar.toPaid.setOnClickListener {
                findNavController().navigate(R.id.action_reservationFragment_to_paidFragment)
            }
            addTourist.add.setOnClickListener {
                if (reservationViewModel.isValidSizeOfTourists()) {
                    reservationViewModel.addTourist()
                } else {
                    view?.let { view ->
                        Snackbar.make(view, getString(R.string.MAX_TOURIST_COUNT), Snackbar.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }
    }

    private fun attachObservers() {
        reservationViewModel.tourists.observe(viewLifecycleOwner) { touristList ->
            touristAdapter.differ.submitList(touristList)
        }
    }

    private fun applyAdapters() {
        binding.touristsRv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = touristAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}