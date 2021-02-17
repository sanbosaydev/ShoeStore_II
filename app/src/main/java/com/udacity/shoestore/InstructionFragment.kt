package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentInstructionBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_instruction, container,
                false
            )
        binding.btnNext.setOnClickListener {
            val action = InstructionFragmentDirections
                .actionInstructionFragmentToShoeListFragment()
            findNavController().navigate(action)
        }

        return binding.root
    }
}