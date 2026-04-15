package com.example.pokedex.Screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.PokemonCard
import com.example.pokedex.R
import com.example.pokedex.model.PokemonDetail
import com.example.pokedex.model.Pokemons
import com.example.pokedex.model.Result
import com.example.pokedex.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun Home(modifier: Modifier = Modifier) {

    var pokemonState by remember {
        mutableStateOf("")
    }

    var pokemons by remember {
        mutableStateOf<List<Result>>(emptyList())
    }

    LaunchedEffect(Unit) {
        val call = RetrofitFactory().getPokemonService().getAllPokemon()
        call.enqueue(object : Callback<Pokemons> {
            override fun onResponse(
                call: Call<Pokemons>, response: Response<Pokemons>
            ) {
                pokemons = response.body()?.results ?: emptyList()
            }

            override fun onFailure(
                call: Call<Pokemons>, t: Throwable
            ) {
                Log.i("Teste", "${t.message}")
            }
        })
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = modifier
                .background(Color(207, 38, 44, 255))
                .padding(15.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.pokeball),
                contentDescription = "",
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Pokédex",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }
        OutlinedTextField(
            value = pokemonState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            onValueChange = { pokemonState = it },
            label = { Text("Nome ou ID") },
            trailingIcon = {
                IconButton(onClick = {
                    val call = RetrofitFactory().getPokemonService().getPokemonByName(
                        name = pokemonState
                    )
                    call.enqueue(object : Callback<PokemonDetail> {

                        override fun onResponse(
                            call: Call<PokemonDetail>, response: Response<PokemonDetail>
                        ) {
                            Log.i("Teste", "${response.body()}")
                        }

                        override fun onFailure(call: Call<PokemonDetail>, t: Throwable) {
                            Log.i("Teste", "${t.message}")
                        }
                    })
                }) {
                    Icon(
                        imageVector = Icons.Default.Search, contentDescription = ""
                    )
                }

            })
        LazyVerticalGrid(
            columns = GridCells.Fixed(3)
        ) {
            items(pokemons) {
                PokemonCard(it)
            }
        }

    }

}