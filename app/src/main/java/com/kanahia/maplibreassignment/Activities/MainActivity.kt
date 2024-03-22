package com.kanahia.maplibreassignment.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kanahia.maplibreassignment.ViewModel.RootViewModel
import com.kanahia.maplibreassignment.ViewModel.RootViewModelFactory
import com.kanahia.maplibreassignment.api.Repository
import com.kanahia.maplibreassignment.databinding.ActivityMainBinding
import com.kanahia.maplibreassignment.utils.ItemAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar= binding.toolbar
        val recyclerView = binding.recyclerView

        setSupportActionBar(toolbar)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiService = retrofit.create(Repository.ApiService::class.java)
        val repository = Repository(apiService,this@MainActivity)
        val rootViewModel = ViewModelProvider(this, RootViewModelFactory(repository))
            .get(RootViewModel::class.java)
        rootViewModel.fetchItems()

        rootViewModel.items.observe(this, Observer { items ->
            val adapter = ItemAdapter(items.tracks) { item ->
                showMap(item.id)
            }
            recyclerView.adapter = adapter
        })

    }

    private fun showMap(id: String) {
        val intent = Intent(this,MapActivity::class.java)
        intent.putExtra("id",id)
        startActivity(intent)
    }

    private companion object{
        const val BASE_URL = "https://envirocar.org/"
    }
}