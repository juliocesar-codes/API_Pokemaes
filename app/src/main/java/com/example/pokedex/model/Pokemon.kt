package com.example.pokedex.model

data class PokemonListResponse (
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)

data class PokemonDetail(
    val sprites: Sprites,
    val name: String,
    val id: Int
)

data class Sprites(
    val front_default: String
)

data class Abilities(
    val ability: String
)
