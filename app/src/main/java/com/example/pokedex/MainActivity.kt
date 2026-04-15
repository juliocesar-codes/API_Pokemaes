package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokedex.Screens.DetailPokemon
import com.example.pokedex.Screens.Home
import com.example.pokedex.model.PokemonDetail
import com.example.pokedex.model.Result
import com.example.pokedex.ui.theme.PokedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Home(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PokemonCard(pokemon: Result, pokemonDetail: PokemonDetail) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .clickable{

            }
    )
    {

        val id = pokemon.url
            .split("/")
            .filter { it.isNotEmpty() }
            .last()

        var colorBackground by remember {
            mutableStateOf(Color(0xFFFAFAFA))
        }

        var colorTextResult by remember {
            mutableStateOf(Color.Black)
        }

        val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png"

//        if (pokemonDetail.types == "dragon"){
//            println("batata")
//        }

        Column(
            modifier = Modifier
        ) {
            Row(
                Modifier.fillMaxWidth()

            ) {
                Text(
                    text = "#$id",
                    textAlign = TextAlign.End,
                    color = Color(207,28,44)
                )}
            AsyncImage(
                model = imageUrl,
                contentDescription = pokemon.name,
                modifier = Modifier.size(150.dp)
            )
            Row(
                Modifier
                  .fillMaxWidth()
                  .background(Color(207, 38, 44, 255)),
            ) {
                Text(
                    text = pokemon.name,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}