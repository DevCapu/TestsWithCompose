package br.com.devcapu.jetpackcomposetest

data class UiState(
    val searchUiState: SearchUiState = SearchUiState(),
    var isButtonEnabled: Boolean = false,
    var result: ResultUiState? = null,
)

data class SearchUiState(
    val cep: String = "",
    val isShowingError: Boolean = false,
)

data class ResultUiState(
    val cep: String,
    val logradrouro: String,
    val complemento: String,
    val bairro: String,
    val localidade: String,
    val uf: String,
    val ddd: String,
)