package com.example.pokedex.service

import com.example.pokedex.model.PokemonDetail
import com.example.pokedex.model.Pokemons
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("pokemon/{name}")
    fun getPokemonByName(@Path("name") name: String): Call<PokemonDetail>

    @GET("pokemon?limit=1023")
    fun getAllPokemon(): Call<Pokemons>
}