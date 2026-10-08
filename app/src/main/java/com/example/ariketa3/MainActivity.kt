package com.example.ariketa3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ariketa3.ui.theme.Ariketa3Theme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.layout.ContentScale


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ariketa3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Ariketa(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}




@Composable
fun Ariketa(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize()) {
        AriketaFondoa()
        AriketaTestua()
    }
}


@Composable
fun AriketaTestua (modifier: Modifier = Modifier) {

    var nota by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(36.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Ikaslearen nota: ",
                lineHeight = 80.sp,
                fontSize = 24.sp
            )
            Text(
                text = "$nota",
                fontSize = 24.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            if (nota < 10) {
                nota++
            }
            }) {
                Text(text = "Gehitu nota")
            }

    }
}

@Composable
fun AriketaFondoa (modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.fondoariketa3)
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxSize()
    )
}




@Preview(showBackground = true)
@Composable
fun AriketaPreview() {
    Ariketa3Theme {
        Ariketa()
    }
}
