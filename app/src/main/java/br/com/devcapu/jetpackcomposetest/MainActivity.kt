package br.com.devcapu.jetpackcomposetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.devcapu.jetpackcomposetest.extensions.isAValidCep
import br.com.devcapu.jetpackcomposetest.ui.theme.JetpackComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTestTheme {
                SearchScreen()
            }
        }
    }
}

@Composable
fun SearchScreen() {
    var CEP by remember { mutableStateOf("") }
    var isButtonEnabled by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { AppBar() },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.insert_cep_label),
                    style = MaterialTheme.typography.h4
                )

                Text(
                    text = stringResource(R.string.search_info),
                    style = MaterialTheme.typography.body1
                )

                TextField(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    value = CEP,
                    onValueChange = {
                        CEP = it
                        isButtonEnabled = CEP.isAValidCep()
                    },
                    label = {
                        Text(
                            text = stringResource(R.string.cep_label),
                            style = MaterialTheme.typography.caption
                        )
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = MaterialTheme.colors.primary,
                        focusedLabelColor = MaterialTheme.colors.primary
                    )

                )
            }

            Column(
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Divider(modifier = Modifier.fillMaxWidth())
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    onClick = { /*TODO*/ },
                    enabled = isButtonEnabled,
                    colors = ButtonDefaults.buttonColors(
                        disabledBackgroundColor = Color(0xFFC7C7C7)
                    )
                ) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = stringResource(R.string.search_cep_button),
                        style = MaterialTheme.typography.body2,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
private fun AppBar() {
    TopAppBar(
        modifier = Modifier.shadow(
            elevation = 16.dp,
            shape = RoundedCornerShape(
                bottomStart = 8.dp,
                bottomEnd = 8.dp
            )
        ),
        backgroundColor = Color.White,
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.app_name),
            textAlign = Center,
            style = MaterialTheme.typography.body2
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    JetpackComposeTestTheme {
        SearchScreen()
    }
}