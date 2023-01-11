package br.com.devcapu.jetpackcomposetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.devcapu.jetpackcomposetest.data.CepRepository
import br.com.devcapu.jetpackcomposetest.data.Result
import br.com.devcapu.jetpackcomposetest.extensions.isAValidCep
import br.com.devcapu.jetpackcomposetest.ui.components.AppBar
import br.com.devcapu.jetpackcomposetest.ui.components.ResultsFromSearch
import br.com.devcapu.jetpackcomposetest.ui.components.SearchSection
import br.com.devcapu.jetpackcomposetest.ui.theme.Disabled
import br.com.devcapu.jetpackcomposetest.ui.theme.JetpackComposeTestTheme
import br.com.devcapu.jetpackcomposetest.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var state by remember { mutableStateOf(UiState()) }
            JetpackComposeTestTheme {
                SearchScreen(
                    uiState = state,
                    onCepChanged = {
                        state = state.copy(cep = it, isButtonEnabled = it.isAValidCep())
                    },
                    onButtonClicked = {
                        state = search(state)
                    }
                )
            }
        }
    }

    private fun search(state: UiState): UiState {
        val cep = state.cep
        val showError = cep.contains(",") || cep.contains(".")
        return if (showError) {
            state.copy(isShowingError = showError)
        } else {
            state.copy(
                result = CepRepository().search(cep),
                isShowingError = false
            )
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
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = White)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp)
            ) {
                SearchSection(
                    uiState = uiState,
                    onCepChanged = onCepChanged,
                    onButtonClicked = onButtonClicked
                )
                uiState.result?.let { ResultsFromSearch(result = it) }
            }

            Column(modifier = Modifier.align(Alignment.BottomCenter)) {
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

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    JetpackComposeTestTheme {
        SearchScreen(
            uiState = UiState(
                result = Result(
                    "",
                    "Rua dos bobos",
                    "",
                    "",
                    "",
                    "",
                    ""
                )
            ),
            onCepChanged = {},
            onButtonClicked = {},
        )
    }
}