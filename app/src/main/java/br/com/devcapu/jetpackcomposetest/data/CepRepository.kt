package br.com.devcapu.jetpackcomposetest.data

class CepRepository {

    fun search(cep: String) =
        Result(
            cep = "01001-000",
            logradrouro = "Rua dos Bobos",
            complemento = "lado ímpar",
            bairro = "Sé",
            localidade = "São Paulo",
            uf = "SP",
            ddd = "11"
        )
}

data class Result(
    val cep: String,
    val logradrouro: String,
    val complemento: String,
    val bairro: String,
    val localidade: String,
    val uf: String,
    val ddd: String,
)