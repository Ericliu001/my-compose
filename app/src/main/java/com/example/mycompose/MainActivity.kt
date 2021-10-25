package com.example.mycompose

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.net.Uri
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mycompose.ui.theme.MyComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Container(buttonClicked = { launchUber() })
                }
            }
        }
    }

    fun launchUber() {
        val openURL = Intent(Intent.ACTION_VIEW)
        openURL.flags = FLAG_ACTIVITY_NEW_TASK
        openURL.data =
            Uri.parse("https://m.uber.com/looking?drop%5B0%5D=%7B%22id%22%3A%22c8a04f89-375e-7cba-9545-b32f554276b4%22%2C%22addressLine1%22%3A%22San%20Francisco%20Marriott%20Marquis%22%2C%22addressLine2%22%3A%22780%20Mission%20St%2C%20San%20Francisco%2C%20California%22%2C%22provider%22%3A%22uber_places%22%2C%22locale%22%3A%22en-US%22%2C%22latitude%22%3A37.785023%2C%22longitude%22%3A-122.40481%7D&pickup=%7B%22label%22%3A%22%22%2C%22addressLine1%22%3A%22Strata%20Apartments%22%2C%22addressLine2%22%3A%22555%20Mission%20Rock%20St%2C%20San%20Francisco%2C%20California%22%2C%22latitude%22%3A37.7728338%2C%22longitude%22%3A-122.3906821%7D&state=i81t62qYnGa2ys8TU5Lb-WIMB8e0hraXu6jQHaJfT_M%3D&vehicle=a1111c8c-c720-46c3-8534-2fcdd730040d")
        this.startActivity(openURL)
    }

}


@Composable
fun Container(buttonClicked: () -> Unit) {
    Column {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.Cyan)
        ) {
            Conversation(buttonClicked)
        }

        Box(
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .background(Color.Green)
        ) {
            RequestButton(buttonClicked)
        }
    }
}


@Composable
fun RequestButton(buttonClicked: () -> Unit) {
    Button(
        modifier = Modifier.wrapContentSize(),
        onClick = { buttonClicked() }) {
        Text(text = "Click")
    }
}


@Composable
fun Conversation(buttonClicked: () -> Unit) {
    LazyColumn {
//        for (i in 0..4) {
//            item {
//                Greeting(name = "Eric")
//            }
//        }
        items(listOf("Eric", "Beta", "Brandon", "Felix")) { element ->
            Greeting(name = element, buttonClicked)
        }
    }
}

@Composable
fun Greeting(name: String, buttonClicked: () -> Unit) {

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
                painter = painterResource(id = R.drawable.ic_badgessuvblack),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .border(1.5.dp, color = colors.secondary, RoundedCornerShape(5.dp))
            )

            Spacer(modifier = Modifier.size(5.dp))


            Column(modifier = Modifier
                .weight(1f)
                .clickable { isExpanded = !isExpanded }) {
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

            RequestButton(buttonClicked)
        }
    }
}

//@Preview(
//    "Light Theme",
//    showBackground = true,
//)
//@Composable
//fun DefaultPreview() {
//    MyComposeTheme {
//        Container(this)
//    }
//}
//
//@Preview(
//    "Dark Theme",
//    showBackground = true,
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//)
//@Composable
//fun DarkModePreview() {
//    MyComposeTheme {
//        Container(this)
//    }
//}