package com.example.musicplayer


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.musicplayer.ui.theme.MusicPlayerTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.ui.graphics.Brush
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material3.IconButton
//I asked ChatGPT about what do I need to import
//Reference to Spotify play page

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicPlayerTheme {
                Box(modifier = Modifier
                    .fillMaxSize()
                    //ChatGPT taught me how to write this Gradient
                    .background(brush = Brush.verticalGradient(
                        colors = listOf(Color(0xFF1A2B6B),Color(0xFF0D1A40))))){}
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ){
                    Text("Melodrama",
                        color = Color.White,
                        style = TextStyle(fontSize = 16.sp,
                            fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Box(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(top = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.lordemelodrama),
                            contentDescription = "Album Cover",
                            modifier = Modifier
                                .size(400.dp)
                                .padding(top = 8.dp)
                                .align(Alignment.TopStart)
                        )
                    }
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .align(Alignment.Start),
                    ){
                        Text("The Louvre",
                            modifier = Modifier
                                .padding(8.dp, top = 16.dp)
                                .weight(1f),
                            color = Color.White,
                            style = TextStyle(
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold))
                        Icon(
                            imageVector = Icons.Rounded.CheckCircle,
                            contentDescription = "Save Button",
                            tint = Color.Green,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                    Text("Lorde",
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.Start),
                        color = Color.Gray)
                    Slider(
                        value = 0.3f,
                        colors = SliderDefaults.colors(
                            disabledThumbColor = Color.White,
                            disabledActiveTrackColor = Color.White,
                            disabledActiveTickColor = Color.White,
                            disabledInactiveTickColor = Color.White,
                            disabledInactiveTrackColor = Color.Gray
                        ),
                        onValueChange = {},
                        enabled = false)
                    //I asked ChatGPT how to find these icons
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly){
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Play icon",
                            tint = Color.White,
                            modifier = Modifier.size(32.dp)
                        )
                        Box(
                            modifier = Modifier
                                .background(Color.White, shape = CircleShape)
                                .size(56.dp),
                            contentAlignment = androidx.compose.ui.Alignment.Center,
                            //this line is written by ChatGPT
                        ){
                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Filled.Pause,
                                    contentDescription = "Pause Icon",
                                    tint = Color(0xFF0D1A40),
                                    modifier = Modifier.size(32.dp)
                                )
                            }
                        }
                        Icon(
                            imageVector = Icons.Default.SkipNext,
                            contentDescription = "Skip icon",
                            tint = Color.White,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            }
        }
    }
}

