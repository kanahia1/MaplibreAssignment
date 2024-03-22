package com.kanahia.maplibreassignment.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kanahia.maplibreassignment.api.Repository

class RootViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(RootViewModel::class.java)) {
            return RootViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
