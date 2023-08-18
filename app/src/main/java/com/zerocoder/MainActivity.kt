package com.zerocoder

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.tooling.preview.Preview
import com.zerocoder.ui.theme.Compose_Test_AppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Greeting("Susant")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String) {
//    Text(
//        text = "Hello $name!",
//        textAlign = TextAlign.Center,
//        color = Color.Blue,
//        fontSize = 25.sp,
//        fontStyle = FontStyle.Italic
//    )
//    Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "Call"
//    )
//    Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
//        containerColor= Color.Blue, contentColor = Color.Cyan
//    )) {
//        Text(text = "Submit")
//    }
    val state = remember { mutableStateOf("") }
    TextField(
        value = state.value,
        onValueChange = { state.value = it },
        label = { Text("Enter Your Message") })

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Compose_Test_AppTheme {
        Greeting("Android")
    }
}