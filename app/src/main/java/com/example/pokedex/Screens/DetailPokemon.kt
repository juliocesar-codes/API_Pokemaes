package com.example.pokedex.Screens

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.R

@Composable
fun DetailPokemon(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(121,192,73)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(300.dp)
        )
             {
                Icon(
                    painter = painterResource(R.drawable.pokeball),
                    contentDescription = "",
                    modifier = Modifier
                        .size(230.dp)
                        .align(Alignment.TopEnd)
                        .graphicsLayer(alpha = 0.2f),
                )
                 Row(
                     modifier = Modifier.fillMaxWidth()
                         .padding(horizontal = 30.dp),
                     horizontalArrangement = Arrangement.SpaceBetween
                 ) {
                     Row() {
                         Icon(
                             tint = Color.White,
                             imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                             contentDescription = ""
                         )
                         Spacer(modifier = Modifier.size(5.dp))
                         Text(
                             text = "Batatinha",
                             textAlign = TextAlign.Start,
                             color = Color.White,
                             fontSize = 20.sp,
                             fontWeight = FontWeight.Bold
                         )
                     }
                     Text(
                         text = "#001",
                         color = Color.White,
                         fontWeight = FontWeight.Bold,
                         fontSize = 14.sp
                     )
                 }
                 Image(
                     painter = painterResource(R.drawable.pokeball),
                     contentDescription = "",
                     modifier = Modifier.align(Alignment.BottomCenter).size(200.dp)
                 )
            }
        Card(
            Modifier
                .height(540.dp)
                .width(395.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Grass",
                    )
                    Spacer(modifier = Modifier.size(20.dp))
                    Text(
                        text = "Poison"
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "About",
                        modifier = Modifier,
                        color = Color.Green,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column() {
                        Row() {
                            Icon(imageVector = Icons.Default.Home, contentDescription = "")
                            Text("6,9 kg")
                        }
                        Text("Weight")
                    }
                    Column() {
                        Row() {
                            Icon(imageVector = Icons.Default.Home, contentDescription = "")
                            Text("6,9 kg")
                        }
                        Text("Weight")
                    }
                    Column() {
                        Text("Chlorofina")
                        Text("Covid")
                        Text("Moves")
                    }
                }
                Row() {
                    Text("Mussum Ipsum, cacilds vidis litro abertis.  Quem manda na minha terra sou euzis! Em pé sem cair, deitado sem dormir, sentado sem cochilar e fazendo pose. Não sou faixa preta cumpadi, sou preto inteiris, inteiris. Interagi no mé, cursus quis, vehicula ac nisi.")
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = "Base Stats",
                        modifier = Modifier,
                        color = Color.Green,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold

                    )
                }
                Row(modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {
                    Column() {
                        Text("HP")
                        Text("ATK")
                        Text("DEF")
                        Text("SATK")
                        Text("SDEF")
                        Text("SPD")
                    }
                    Column() {
                        Row() {
                            Text("045")
                        }
                        Row() {Text("045") }
                        Row() {Text("045") }
                        Row() {Text("045") }
                        Row() { Text("045")}
                        Row() { Text("045")}
                    }
                    Column(modifier = Modifier.height(140.dp), verticalArrangement = Arrangement.SpaceAround) {
                        Row(modifier = Modifier.width(250.dp).height(10.dp).background(Color.Green)) { }
                        Row(modifier = Modifier.width(100.dp).height(10.dp).background(Color.Green)) { }
                        Row(modifier = Modifier.width(100.dp).height(10.dp).background(Color.Green)) { }
                        Row(modifier = Modifier.width(100.dp).height(10.dp).background(Color.Green)) { }
                        Row(modifier = Modifier.width(100.dp).height(10.dp).background(Color.Green)) { }
                        Row(modifier = Modifier.width(100.dp).height(10.dp).background(Color.Green)) { }
                       }
                }

            }
        }


        }
    }
