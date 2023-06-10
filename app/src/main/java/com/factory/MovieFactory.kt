package com.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.repository.MovieRepository
import com.viewmodel.MovieViewModel

class MovieFactory (val repository: MovieRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(repository) as T
    }
}