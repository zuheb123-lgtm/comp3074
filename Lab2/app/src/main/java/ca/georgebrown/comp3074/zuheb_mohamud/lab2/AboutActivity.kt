package ca.georgebrown.comp3074.zuheb_mohamud.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.georgebrown.comp3074.zuheb_mohamud.lab2.ui.theme.Lab2Theme

class AboutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Lab2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LabEx2(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LabEx2(modifier: Modifier = Modifier) {

    val cnt = remember { mutableIntStateOf(0) }
    val step = remember { mutableIntStateOf(1) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Application Logo",
                modifier = Modifier
                    .width(200.dp)
                    .height(100.dp)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("${cnt.intValue}")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            Button(
                onClick = {},
                modifier = Modifier.weight(1f)
            ) {
                Text("-")
            }

            Button(
                onClick = {},
                modifier = Modifier.weight(1f)
            ) {
                Text("+")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            Button(
                onClick = {},
                modifier = Modifier.weight(1f)
            ) {
                Text("Reset")
            }

            Button(
                onClick = {},
                modifier = Modifier.weight(1f)
            ) {
                Text("Step")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {

    Lab2Theme {
        LabEx2()
    }
}