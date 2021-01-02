package com.udacity.shoestore.viewmodels

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {


    private val shoesDetails = ArrayList<Shoe>()

    private val _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoesList: LiveData<MutableList<Shoe>>
        get() = _shoesList

    init {
        _shoesList.value = ArrayList()
    }

    fun saveData(shoe: Shoe) {
        shoesDetails.add(shoe)
        _shoesList.value = shoesDetails
    }
}