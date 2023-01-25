package br.com.devcapu.jetpackcomposetest

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import br.com.devcapu.jetpackcomposetest.extensions.isAValidCep
import org.junit.Rule
import org.junit.Test

class SearchScreenTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun deve_mostrarBotaoDeProcurarCepDesabilitado() {
        rule.setContent { SearchScreen() }

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
            )
        }

        rule.onNodeWithText("CEP").performTextInput("10001-111")

        val button = rule.onNodeWithText("Procurar CEP")
        button.assertIsDisplayed()
        button.assertIsEnabled()
    }
}