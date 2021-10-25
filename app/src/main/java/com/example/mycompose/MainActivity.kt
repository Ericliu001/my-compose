package com.example.mycompose

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.content.res.Configuration
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
                    Container(buttonClicked = { uri -> launchUber(uri = uri) })
                }
            }
        }
    }

    fun launchUber(uri: Uri) {
        val openURL = Intent(Intent.ACTION_VIEW)
        openURL.flags = FLAG_ACTIVITY_NEW_TASK
        openURL.data = uri
        this.startActivity(openURL)
    }

}


@Composable
fun Container(buttonClicked: (Uri) -> Unit) {
    Column {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.Gray)
        ) {
            QuickNavigationList(buttonClicked)
        }
    }
}


@Composable
fun RequestButton(uri: Uri, buttonClicked: (Uri) -> Unit) {
    Button(
        modifier = Modifier.wrapContentSize(),
        onClick = { buttonClicked(uri) }) {
        Text(text = "Click")
    }
}


@Composable
fun QuickNavigationList(buttonClicked: (Uri) -> Unit) {
    LazyColumn {
//        for (i in 0..4) {
//            item {
//                Greeting(name = "Eric")
//            }
//        }
        items(NavigationRepository().getNavigations()) { element ->
            ShowQuickNavigation(quickNavigation = element, buttonClicked)
        }
    }
}

@Composable
fun ShowQuickNavigation(quickNavigation: QuickNavigation, buttonClicked: (Uri) -> Unit) {

    var isExpanded by remember {
        mutableStateOf(false)
    }

    val surfaceColor by animateColorAsState(
        targetValue = if (isExpanded) colors.primary else
            colors.surface
    )

    Surface(
        color = surfaceColor,
        shape = shapes.large,
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
                    text = quickNavigation.title,
                    style = typography.body1
                )

                Spacer(modifier = Modifier.size(5.dp))


                Text(
                    style = typography.body2,
                    modifier = Modifier.padding(4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    text = quickNavigation.body,
                )
            }

            RequestButton(quickNavigation.uri, buttonClicked)
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
        Container(buttonClicked = {})
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
        Container { }
    }
}