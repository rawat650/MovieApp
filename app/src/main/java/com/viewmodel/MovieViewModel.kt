package com.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.model.MovieData
import com.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel(val repository: MovieRepository) :ViewModel(){
    val movieData = MutableLiveData<MovieData>()
      fun getData(title:String, key:String){

         viewModelScope.launch {
             var response = repository.getData(title,key)
             movieData.postValue(response.body())

         }

    }
}