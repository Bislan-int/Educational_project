package com.example.educationalproject.domain

import com.example.educationalproject.data.MainRepository

class Interactor(val repo: MainRepository) {
    fun getFilmsDB(): List<Film> = repo.filmsDataBase
}