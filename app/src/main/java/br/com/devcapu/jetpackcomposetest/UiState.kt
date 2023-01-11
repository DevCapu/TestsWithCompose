package br.com.devcapu.jetpackcomposetest

import br.com.devcapu.jetpackcomposetest.data.Result

data class UiState(
    val cep: String = "",
    val isShowingError: Boolean = false,
    var isButtonEnabled: Boolean = false,
    var result: Result? = null,
)