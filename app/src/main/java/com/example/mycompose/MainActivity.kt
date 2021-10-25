package com.example.mycompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycompose.ui.theme.MyComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Container()
                }
            }
        }
    }
}

@Composable
fun Container() {
    Box {
        Box(modifier = Modifier
            .fillMaxSize()
            .align(Alignment.TopCenter)
            .background(Color.Cyan)) {
            Conversation()
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(150.dp)
                .fillMaxWidth()
                .background(Color.Green)
        )
    }
}

@Composable
fun Conversation() {
    LazyColumn {
//        for (i in 0..4) {
//            item {
//                Greeting(name = "Eric")
//            }
//        }
        items(listOf("Eric", "Beta", "Brandon", "Felix")) { element ->
            Greeting(name = element)
        }
    }
}

@Composable
fun Greeting(name: String) {

    var isExpanded by remember {
        mutableStateOf(false)
    }

    val surfaceColor by animateColorAsState(
        targetValue = if (isExpanded) colors.primary else
            colors.surface
    )

    Surface(
        color = surfaceColor,
        shape = shapes.medium,
        elevation = 1.dp,
        modifier = Modifier.animateContentSize()
    ) {
        Row(modifier = Modifier.padding(5.dp)) {
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, color = colors.secondary, CircleShape)
            )

            Spacer(modifier = Modifier.size(5.dp))


            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(
                    text = "Hello $name!",
                    style = typography.body1
                )

                Spacer(modifier = Modifier.size(5.dp))


                Text(
                    style = typography.body2,
                    modifier = Modifier.padding(4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    text = "Composable functions can store local state in memory by using remember, and track changes to the value passed to mutableStateOf. Composables (and its children) using this state will get redrawn automatically when the value is updated. We call this recomposition.",
                )
            }
        }
    }
}

@Preview(
    "Light Theme",
    showBackground = true,
)
@Composable
fun DefaultPreview() {
    MyComposeTheme {
        Conversation()
    }
}

@Preview(
    "Dark Theme",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun DarkModePreview() {
    MyComposeTheme {
        Conversation()
    }
}