package com.example.pokedex.model

data class Pokemons(
    val results: List<Result>,
)

data class Result(
    val name: String,
    val url: String
)

data class PokemonDetail(
    val sprites: Sprites,
    val name: String,
    val id: Int,
    val abilities: List<AbilitySlot>,
    val weight: Int,
    val height: Int,
    val stats: List<StatSlot>,
    val types: List<TypesSlot>
)

data class Sprites(
    val front_default: String
)

data class TypesSlot(
    val type: Type
)

data class Type(
    val name: String
)

data class AbilitySlot(
    val ability: Ability
)

data class Ability(
    val name: String
)

data class StatSlot(
    val base_stat: Int,
    val stat: Stat
)

data class Stat(
    val name: String
)
