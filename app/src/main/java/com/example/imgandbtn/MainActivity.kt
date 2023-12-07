package com.example.imgandbtn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.imgandbtn.ui.theme.ImgAndBtnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImgAndBtnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}
@Composable
fun MainScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        ScrollableImages()
        Spacer(modifier = Modifier.padding(35.dp))
        BottomButtons()

    }
}
@Composable
fun ScrollableImages(){
    val images = listOf(
        R.drawable.tiger,
        R.drawable.tiger,
        R.drawable.tiger,
        R.drawable.tiger,
        R.drawable.tiger,
        R.drawable.tiger
    )
    LazyRow(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
        .padding(8.dp)){
 items(images){imageIndex ->
     Image(painter = painterResource(id = imageIndex), contentDescription ="Learning Images" ,
         modifier = Modifier
             .width(350.dp)
             .height(350.dp)
             .padding(4.dp)
             .clip(MaterialTheme.shapes.medium))

         }
     }
 }
@Composable
fun BottomButtons(){
    Column ( modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)){

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Filled Btn")
            }
            FilledTonalButton(onClick = { /*TODO*/ }) {
                Text(text ="Tonal Btn" )
            }
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "OutLined Btn")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center){
            ElevatedButton(onClick = { /*TODO*/ }) {
                Text(text = "ElevatedBtn")
            }
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Text Btn")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImgAndBtnTheme {
        MainScreen()
    }
}