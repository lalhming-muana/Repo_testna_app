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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

data class ImageInfo(val resourceId: Int, val description: String, val author: String)

@Composable
fun Greeting(modifier: Modifier = Modifier) {

    val images = listOf(
        ImageInfo(resourceId = R.drawable.london_bridge,description ="London Bridge", author="Frank Shamrock" ),
        ImageInfo(resourceId = R.drawable.eiffel_tower,description ="Eiffel Tower", author="Royce Gracie"  ),
        ImageInfo(resourceId = R.drawable.statue_of_liberty,description ="Statue of liberty", author="Tim Dillion"  ))

        Column(modifier = Modifier.padding(top= 20.dp),
                          verticalArrangement = Arrangement.Center,
                          horizontalAlignment = Alignment.CenterHorizontally  ) {
            val image = painterResource(R.drawable.london_bridge)

            var currentIndex by remember { mutableStateOf(0) }

            Image(
                painter = painterResource(id = images[currentIndex].resourceId),
                contentDescription = images[currentIndex].description,
                modifier = Modifier.size(height=180.dp, width= 180.dp)

            )

            Text(
                text = images[currentIndex].description,
                modifier = modifier,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = images[currentIndex].author,
                modifier = modifier,
                fontSize = 10.sp
            )
            Spacer(Modifier.height(20.dp))
            Row(){
                    Button(onClick = { if (currentIndex > 0) {
                        currentIndex--
                    }
                    },
                        enabled = currentIndex > 0
                    )
                    {
                        Text("Previous")
                    }


                    Button(onClick = { if (currentIndex < images.size - 1) {
                        currentIndex++
                    }
                    },
                        enabled = currentIndex < images.size - 1,
                        modifier = Modifier.padding(start = 20.dp)
                    )

                         {
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