package com.example.educationalproject.domain

import com.example.educationalproject.API
import com.example.educationalproject.data.Entity.TmdbResultsDto
import com.example.educationalproject.data.MainRepository
import com.example.educationalproject.data.TmdbApi
import com.example.educationalproject.utils.Converter
import com.example.educationalproject.viewmodel.HomeFragmentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interactor(private val repo: MainRepository, private val retrofitService: TmdbApi) {

    fun getFilmsFromApi(page: Int, callback: HomeFragmentViewModel.ApiCallback) {
        retrofitService.getFilms(API.KEY, "ru-RU", page).enqueue(object : Callback<TmdbResultsDto> {
            override fun onResponse(call: Call<TmdbResultsDto>, response: Response<TmdbResultsDto>) {
                callback.onSuccess(Converter.convertApiListToDtoList(response.body()?.tmdbFilms))
            }

            override fun onFailure(call: Call<TmdbResultsDto>, t: Throwable) {
                callback.onFailure()
            }
        })
    }
}