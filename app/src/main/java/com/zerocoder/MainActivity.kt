package com.zerocoder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GreetingPreview();
        }
    }
}


@Composable
fun ContactComponent(image: Int, name: String, occupation: String) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(Color.Magenta),
        modifier = Modifier
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "images",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )
            ItemDescription(name, occupation, Modifier.weight(.8f))
        }
    }
}

@Composable
private fun ItemDescription(name: String, occupation: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = name,
            fontSize = 15.sp,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = occupation,
            fontSize = 12.sp,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview(heightDp = 500)
@Composable
fun GreetingPreview() {
    //For RecyclerView
    LazyColumn(content = {
        items(getCatList()) { item ->
            ContactComponent(item.img, item.name, item.ocp)
        }
    })
    //BElow Code for Noramal Colum
//    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//        getCatList().map { item ->
//            ContactComponent(item.img, item.name, item.ocp)
//        }
//    }

}

data class Category(val img: Int, val name: String, val ocp: String)

fun getCatList(): List<Category> {
    val list = mutableListOf<Category>()
    list.add(Category(R.drawable.man, "Susant", "JavaDeveloper"))
    list.add(Category(R.drawable.man, "Suresh", "JavaDeveloper"))
    list.add(Category(R.drawable.man, "Hari", "JavaDeveloper"))
    list.add(Category(R.drawable.man, "Saniya", "JavaDeveloper"))
    list.add(Category(R.drawable.man, "Susant", "JavaDeveloper"))
    list.add(Category(R.drawable.man, "Suresh", "JavaDeveloper"))
    list.add(Category(R.drawable.man, "Hari", "JavaDeveloper"))
    list.add(Category(R.drawable.man, "Saniya", "JavaDeveloper"))
    list.add(Category(R.drawable.man, "Susant", "JavaDeveloper"))
    list.add(Category(R.drawable.man, "Suresh", "JavaDeveloper"))
    list.add(Category(R.drawable.man, "Hari", "JavaDeveloper"))
    list.add(Category(R.drawable.man, "Saniya", "JavaDeveloper"))
    return list
}