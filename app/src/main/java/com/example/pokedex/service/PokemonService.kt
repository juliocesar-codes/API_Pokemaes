package com.example.pokedex.service

import com.example.pokedex.model.PokemonDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("{name}")
    fun getAllPokemon(@Path("name") name: String): Call<PokemonDetail>

}