package com.example.jetpackapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackapp.ui.theme.JetpackAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val currentContext = LocalContext.current
            val scope = rememberCoroutineScope()
            val snackBarHostState = remember {
                SnackbarHostState()
            }

            JetpackAppTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Title Here")
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary
                            )
                        )
                    },
                    bottomBar = {
                        BottomAppBar(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            contentColor = MaterialTheme.colorScheme.primary,
                        ) {
                            Text(modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                text = "Bottom bar")
                        }
                    },

                    floatingActionButton = {
                                           FloatingActionButton(
                                               onClick = {
                                                    currentContext.startActivity(Intent(currentContext, SecondActivity::class.java))
                                               }
                                           ) {
                                               Icon(Icons.Default.Add, contentDescription = "Add")
                                           }
                    },
                    snackbarHost = {
                        SnackbarHost(hostState = snackBarHostState)
                    },

                    // scaffold mod
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding -> // within scaffolding
                    Column {

                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                        Divider(thickness = 2.dp, color = androidx.compose.ui.graphics.Color.Black)

                        Button(onClick =
                        {
                            scope.launch {
                                val result = snackBarHostState
                                    .showSnackbar(
                                        message = "This is a snackbar",
                                        actionLabel = "Action",
                                        duration = SnackbarDuration.Indefinite
                                    )

                                when (result) {
                                    SnackbarResult.ActionPerformed -> {

                                    }

                                    SnackbarResult.Dismissed -> {

                                    }
                                }
                            }
                        }) {
                            Text(text = "Ok")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackAppTheme {
        Greeting("Android")
    }
}

//@Preview(showBackground = true)
@Composable
fun TheRow() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .background(androidx.compose.ui.graphics.Color.Cyan)
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Greeting(name = "android1",
            modifier = Modifier
                .border(
                    width = 1.dp,
                    androidx.compose.ui.graphics.Color.Black,
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(5.dp)
        )

        Spacer(modifier = Modifier.size(10.dp))
        Greeting(name = "android2",
            modifier = Modifier
                .border(
                    width = 1.dp,
                    androidx.compose.ui.graphics.Color.Black,
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(5.dp)
        )
        Spacer(modifier = Modifier.size(10.dp))
        Greeting(name = "android3",
            modifier = Modifier
                .border(
                    width = 1.dp,
                    androidx.compose.ui.graphics.Color.Black,
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(5.dp)
        )
    }
}


//@Preview(showBackground = true)
@Composable
fun TheColumn() {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End,
        modifier = Modifier
            .background(androidx.compose.ui.graphics.Color.Cyan)
            .fillMaxWidth(0.5f)
            .height(400.dp)
    ) {
        Greeting(name = "android1",
            modifier = Modifier
                .border(
                    width = 1.dp,
                    androidx.compose.ui.graphics.Color.Black,
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(5.dp)
        )

        Spacer(modifier = Modifier.size(10.dp))
        Greeting(name = "android2",
            modifier = Modifier
                .border(
                    width = 1.dp,
                    androidx.compose.ui.graphics.Color.Black,
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(5.dp)
        )
        Spacer(modifier = Modifier.size(10.dp))
        Greeting(name = "android3",
            modifier = Modifier
                .border(
                    width = 1.dp,
                    androidx.compose.ui.graphics.Color.Black,
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(5.dp)
        )
    }
}

@Composable
fun TheBox() {
    Box (modifier = Modifier
        .background(androidx.compose.ui.graphics.Color.Yellow)
        .size(250.dp))
    {
        Text("center", Modifier.align(Alignment.Center))
        Text("top start", Modifier.align(Alignment.TopStart))
        Text("Top Center", Modifier.align(Alignment.TopCenter))
        Text("Top End", Modifier.align(Alignment.TopEnd))
        Text("Center Start", Modifier.align(Alignment.CenterStart))
        Text("Center End", Modifier.align(Alignment.CenterEnd))
        Text("Bottom Start", Modifier.align(Alignment.BottomStart))
        Text("Bottom Center", Modifier.align(Alignment.BottomCenter))
        Text("Bottom End", Modifier.align(Alignment.BottomEnd))

    }
}

@Composable
fun TextStuff() {
    Column {
        Spacer(modifier = Modifier.height(20.dp))
//                Column {
//                    TheBox()
//                }
        Text(text = "Hello World")
        Text(text = stringResource(id = R.string.customString))

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(androidx.compose.ui.graphics.Color.Blue)) {
                    append("H")
                }
                append("ello ")
                withStyle(style = SpanStyle(androidx.compose.ui.graphics.Color.Red, fontWeight = FontWeight.Bold)) {
                    append("W")
                }
                append("orld")
            },
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(200.dp)
                .padding(20.dp)
                .border(
                    1.dp,
                    androidx.compose.ui.graphics.Color.Black,
                    shape = RoundedCornerShape(15.dp)
                )
        )
    }
}