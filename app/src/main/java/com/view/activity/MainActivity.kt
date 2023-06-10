package com.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.techbulltask.R
import com.example.techbulltask.databinding.ActivityMainBinding
import com.example.techbulltask.databinding.MovieViewBinding
import com.factory.MovieFactory
import com.model.MovieData
import com.network.ApiService
import com.repository.MovieRepository
import com.view.adapter.MovieAdapter
import com.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {
    private val key:String = "dddb2bca"
    val apiService = ApiService.getInstance()
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MovieViewModel
    lateinit var adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        filterData()
        viewModel  =ViewModelProvider(this,MovieFactory(MovieRepository(apiService))).get(MovieViewModel::class.java)
        viewModel.movieData.observe(this, Observer {
            adapter = MovieAdapter(this, listOf(it))
            binding.rcView.layoutManager = LinearLayoutManager(this)
            binding.rcView.adapter = adapter

        })
    }
    fun filterData(){
        binding.search.setOnQueryTextListener(object :androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.getData(newText,key)
                return true
            }

        })
    }
}