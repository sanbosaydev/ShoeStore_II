package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoeListingsViewModel

class ShoeDetailFragment : Fragment() {
    private val shoesViewModel: ShoeListingsViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )
        binding.apply {
            lifecycleOwner = this@ShoeDetailFragment
            shoeListingsViewModel = shoesViewModel
            shoe = Shoe()
            save.setOnClickListener {
                shoesViewModel.addShoe(shoesViewModel.shoe)
                doAction(it)
            }
            cancel.setOnClickListener {
                doAction(it)
            }
        }
        return binding.root
    }

    private fun doAction(view: View) {
        val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
        Navigation.findNavController(view).navigate(action)
    }
}