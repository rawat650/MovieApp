package com.repository

import com.network.ApiService

class MovieRepository(val apiService: ApiService) {
    suspend fun getData(title:String,key:String) = apiService.getMovie(title,key)
}