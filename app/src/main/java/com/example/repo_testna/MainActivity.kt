package com.example.repo_testna

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repo_testna.ui.theme.Repo_testnaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Repo_testnaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {

        Column(modifier = Modifier.padding(top= 20.dp),
                          verticalArrangement = Arrangement.Center,
                          horizontalAlignment = Alignment.CenterHorizontally  ) {
            val image = painterResource(R.drawable.london_bridge)

            Image(
                painter = image,
                contentDescription = "London bridge",
                modifier = Modifier.size(height=180.dp, width= 180.dp)

            )

            Text(
                text = "London Bridge London",
                modifier = modifier
            )
            Spacer(Modifier.height(20.dp))
            Row(){
                    Button(onClick = { /*TODO*/ },
                    )
                    {
                        Text("Previous")
                    }

                    Button(onClick = { /*TODO*/ },
                            modifier= Modifier.padding(start = 10.dp),
                        ) {
                        Text("Next")
                    }
            }
        }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Repo_testnaTheme {
        Greeting()
    }
}