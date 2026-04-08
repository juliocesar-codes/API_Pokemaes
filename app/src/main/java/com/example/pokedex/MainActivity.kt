package com.example.pokedex

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.pokedex.model.PokemonDetail
import com.example.pokedex.model.PokemonResult
import com.example.pokedex.service.RetrofitFactory
import com.example.pokedex.ui.theme.PokedexTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TelaInicial(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}



@Composable
fun TelaInicial(modifier: Modifier = Modifier) {

    var listaPokemon by remember {
        mutableStateOf(listOf<PokemonDetail>())
    }
    Column(modifier = Modifier.fillMaxSize()) {
//        Row() {
//            Icon()
//            Text()
//        }
//        OutlinedTextField()
//        LazyVerticalGrid() {
//
//        }
        Button(onClick = {
            val call = RetrofitFactory().getPokemonService().getAllPokemon(
                name = "Bulbasaur"
            )


            call.enqueue(object: Callback<PokemonDetail> {


                override fun onResponse(
                    call: Call<PokemonDetail>,
                    response: Response<PokemonDetail>
                ) {
                   Log.i("Teste", "${response.body()}")
                }


                override fun onFailure(call: Call<PokemonDetail>, t: Throwable) {
                    Log.i("Teste", "${t.message}")
                }
            })
        }) { }
    }
}