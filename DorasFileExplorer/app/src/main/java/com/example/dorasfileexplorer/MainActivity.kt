package com.example.dorasfileexplorer

import android.os.Bundle
import android.os.Environment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.dorasfileexplorer.ui.theme.DorasFileExplorerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DorasFileExplorerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FileExplorer()
                }
            }
        }
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun FileExplorer() {
    val storageList = listOf(Environment.getExternalStorageDirectory().absolutePath.toString())

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

    }
    Text(
        text = "Your Storage",

        modifier = Modifier.padding(50.dp),

        style = androidx.compose.ui.text.TextStyle(
            color = Color.Black,
            fontSize = TextUnit(value = 20.0F, type = TextUnitType.Sp)
        ), fontWeight = FontWeight.Black
    )

    LazyColumn {

        items(storageList) { storage ->

            Text(storage, modifier = Modifier.padding(50.dp))

            Divider()
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    FileExplorer()
}