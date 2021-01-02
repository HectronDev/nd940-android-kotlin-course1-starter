package com.udacity.shoestore.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoeViewModel
import kotlinx.android.synthetic.main.fragment_shoe_detail.*

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val shoeViewModel by activityViewModels<ShoeViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        binding.shoe = Shoe("","","","")

        val shoes = binding.shoe!!

        binding.btnSave.setOnClickListener{
            if (isEverythingValid()) {

                shoeViewModel.saveData(shoes)
                it.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
            } else {
                Toast.makeText(context,"Some input is empty", Toast.LENGTH_LONG).show()
            }
        }
        binding.btnCancel.setOnClickListener{
            it.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        return binding.root
    }

    private fun isEverythingValid() : Boolean {
        var validInputs = true

        if (binding.editTextShoeName.text.isEmpty() || binding.editTextShoeCompany.text.isEmpty() || binding.editTextShoeSize.text.isEmpty()) {
            validInputs = false
        }

        return validInputs
    }

}