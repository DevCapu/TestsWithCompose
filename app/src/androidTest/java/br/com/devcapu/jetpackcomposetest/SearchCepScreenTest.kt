package br.com.devcapu.jetpackcomposetest

import androidx.activity.ComponentActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import br.com.devcapu.jetpackcomposetest.extensions.isAValidCep
import org.junit.Rule
import org.junit.Test

class SearchCepScreenTest {

    @get:Rule
    val rule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun deve_mostrarBotaoDeProcurarCepDesabilitado() {
        rule.setContent {
            SearchScreen(
                uiState = UiState(),
                onCepChanged = { },
                onButtonClicked = { }
            )
        }

        val button = rule.onNodeWithText("Procurar CEP")

        button.assertIsDisplayed()
        button.assertIsNotEnabled()
    }

    @Test
    fun deve_mostrarBotaoDeProcurarCepHabilitado_QuandoCepForValido() {
        rule.setContent {
            var state by remember { mutableStateOf(UiState()) }
            SearchScreen(
                uiState = state,
                onCepChanged = {
                    val searchUiState = SearchUiState(cep = it)
                    state = state.copy(
                        searchUiState = searchUiState,
                        isButtonEnabled = it.isAValidCep()
                    )
                },
                onButtonClicked = { }
            )
        }

        val cepLabel = rule.activity.getString(R.string.cep_label)
        rule.onNodeWithText(cepLabel).performTextInput("10001-111")

        val buttonText = rule.activity.getString(R.string.search_cep_button)
        val button = rule.onNodeWithText(buttonText)
        button.assertIsDisplayed()
        button.assertIsEnabled()
    }
}