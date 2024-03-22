package com.kanahia.maplibreassignment.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kanahia.maplibreassignment.api.Repository
import com.kanahia.maplibreassignment.models.TracksListModel
import com.kanahia.maplibreassignment.models.TrackModel
import kotlinx.coroutines.launch

class RootViewModel(private val repository: Repository) : ViewModel() {
    private val _items = MutableLiveData<TracksListModel>()
    private val _track = MutableLiveData<TrackModel>()
    val items: LiveData<TracksListModel> get() = _items
    val track: LiveData<TrackModel> get() = _track


    fun fetchItems() {
        viewModelScope.launch {
            try {
                val response = repository.getItems()
                Log.e("PRINT",response.body().toString())
                if (response.isSuccessful) {
                    _items.value = response.body()
                } else {
                }
            } catch (e: Exception) {
                Log.e("PRINT",e.toString())
            }
        }
    }

    fun fetchTrack(trackId : String) {
        viewModelScope.launch {
            try {
                val response = repository.getTrack(trackId)
                if (response.isSuccessful) {
                    _track.value = response.body()
                } else {
                }
            } catch (e: Exception) {
            }
        }
    }

}
