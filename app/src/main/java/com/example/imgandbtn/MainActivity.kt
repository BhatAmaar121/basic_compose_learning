package com.example.imgandbtn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imgandbtn.ui.theme.ImgAndBtnTheme

data class Article(
    val title: String,
    val description: String,
    val imageUrl: String,
    val author: String,
    val followers: String,
    val content: String
)

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val articles = listOf(
            Article(
                title = "Title 1",
                description = "Description 1",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiB6O_lfxeRec_iL5xnCkXpYVSKcbR2ouoMA&usqp=CAU",
                author = "Author 1",
                followers = "4M",
                content = "content 1"
            ),
            Article(
                title = "Title 2",
                description = "Description 2",
                imageUrl = "https://media.istockphoto.com/id/1181366400/photo/in-the-hands-of-trees-growing-seedlings-bokeh-green-background-female-hand-holding-tree-on.jpg?s=1024x1024&w=is&k=20&c=7vTdlKUTmfYvaSlw4r1IdAb3AvXbZlE_L-hqpUVbXYA=",
                author = "Author 2",
                followers = "10M",
                content = "content 1"
            ),
            Article(
                title = "Title 3",
                description = "Description 3",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiB6O_lfxeRec_iL5xnCkXpYVSKcbR2ouoMA&usqp=CAU",
                author = "Author 3",
                followers = "15K",
                content = "content 1"
            ),
            Article(
                title = "Title 3",
                description = "Description 4",
                imageUrl = "https://media.istockphoto.com/id/1317323736/photo/a-view-up-into-the-trees-direction-sky.jpg?s=612x612&w=0&k=20&c=i4HYO7xhao7CkGy7Zc_8XSNX_iqG0vAwNsrH1ERmw2Q=",
                author = "Author 4",
                followers = "12K",
                content = "content 4"
            )
        )
        setContent {
            LazyColumn {
                items(articles) { article ->
                    MainScreen(article = article)
                }
            }
        }
    }
}

@Composable
fun MainScreen(article: Article) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Images()
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = article.title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.tiger),
                contentDescription = "Profile Pic",
                modifier = Modifier
                    .size(50.dp)
                    .padding(4.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            )
            Spacer(modifier = Modifier.padding(end = 8.dp))
            Column {
                Text(text = article.author, modifier = Modifier.padding(bottom = 4.dp))
                Text(text = article.followers, modifier = Modifier.padding(start = 4.dp))
            }
            Spacer(modifier = Modifier.padding(end = 10.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Follow")
            }
        }
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        Text(text = article.description, modifier = Modifier.height(26.dp))
    }
//    @Composable
//    fun Image1(){
//        CoilImage(
//            painter = rememberCoilPainter(request = article.imageUrl),
//            contentDescription = null,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//                .clip(shape = RoundedCornerShape(8.dp)),
//            contentScale = ContentScale.Crop,
//            loading = {
//                Box(
//                    modifier = Modifier.fillMaxSize()
//                        .background(Color.Gray)
//                )
//            }
//        )
//    }
}
@Composable
fun Images() {
    Image(
        painter = painterResource(id = R.drawable.tiger), contentDescription = "Learning Images",
        modifier = Modifier
            .width(450.dp)
            .height(450.dp)
            .padding(4.dp)
            .clip(MaterialTheme.shapes.medium)
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImgAndBtnTheme {
        Images()
    }
}