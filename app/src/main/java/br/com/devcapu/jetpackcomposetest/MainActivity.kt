package br.com.devcapu.jetpackcomposetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.devcapu.jetpackcomposetest.extensions.isAValidCep
import br.com.devcapu.jetpackcomposetest.ui.theme.Disabled
import br.com.devcapu.jetpackcomposetest.ui.theme.JetpackComposeTestTheme
import br.com.devcapu.jetpackcomposetest.ui.theme.White

data class UiState(
    val cep: String = "",
    val isShowingError: Boolean = false,
    var isButtonEnabled: Boolean = false,
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var state by remember { mutableStateOf(UiState()) }
            JetpackComposeTestTheme {
                SearchScreen(
                    uiState = state,
                    onCepChanged = {
                        state = state.copy(
                            cep = it,
                            isButtonEnabled = state.cep.isAValidCep()
                        )
                    },
                    onButtonClicked = {
                        val cep = state.cep
                        state = state.copy(
                            isShowingError = cep.contains(",") || cep.contains(".")
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun SearchScreen(
    uiState: UiState,
    onCepChanged: (String) -> Unit,
    onButtonClicked: () -> Unit,
) {
    Scaffold(topBar = { AppBar() }) {
        Box(modifier = Modifier.fillMaxSize().background(color = White)) {
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
                    modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
                    value = uiState.cep,
                    onValueChange = onCepChanged,
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
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Search
                    ),
                    keyboardActions = KeyboardActions(onSearch = { onButtonClicked() }),
                    isError = uiState.isShowingError,
                )
                if (uiState.isShowingError) {
                    Text(text = stringResource(R.string.error_message))
                }
            }

            Column(
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Divider(modifier = Modifier.fillMaxWidth())
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    onClick = onButtonClicked,
                    enabled = uiState.isButtonEnabled,
                    colors = ButtonDefaults.buttonColors(
                        disabledBackgroundColor = Disabled
                    )
                ) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = stringResource(R.string.search_cep_button),
                        style = MaterialTheme.typography.body2,
                        fontWeight = FontWeight.Bold,
                        color = White
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
        SearchScreen(
            uiState = UiState(),
            onCepChanged = {},
            onButtonClicked = {}
        )
    }
}