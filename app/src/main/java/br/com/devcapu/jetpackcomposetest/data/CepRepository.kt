package br.com.devcapu.jetpackcomposetest.data

import br.com.devcapu.jetpackcomposetest.ResultUiState

class CepRepository {

    fun search(cep: String) =
        ResultUiState(
            cep = "01001-000",
            logradrouro = "Rua dos Bobos",
            complemento = "lado ímpar",
            bairro = "Sé",
            localidade = "São Paulo",
            uf = "SP",
            ddd = "11"
        )
}