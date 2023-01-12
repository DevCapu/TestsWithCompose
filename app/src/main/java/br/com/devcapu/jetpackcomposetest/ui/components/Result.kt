package br.com.devcapu.jetpackcomposetest.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.devcapu.jetpackcomposetest.R
import br.com.devcapu.jetpackcomposetest.ResultUiState

@Composable
fun ResultsFromSearch(result: ResultUiState) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        text = stringResource(R.string.result_label),
        style = MaterialTheme.typography.h4
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        ResultItem(
            title = stringResource(R.string.logradouro_label),
            value = result.logradrouro
        )
        ResultItem(
            title = stringResource(R.string.complmento_label),
            value = result.complemento
        )
        ResultItem(
            title = stringResource(R.string.bairro_label),
            value = result.bairro
        )
        ResultItem(
            title = stringResource(R.string.localidade_label),
            value = result.localidade
        )
        ResultItem(
            title = stringResource(R.string.uf_label),
            value = result.uf
        )
        ResultItem(
            title = stringResource(R.string.ddd_label),
            value = result.ddd
        )
    }
}

@Composable
private fun ResultItem(title: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title)
        Text(
            text = value,
            style = MaterialTheme.typography.caption,
            fontSize = 16.sp
        )
    }
    Divider(Modifier.fillMaxWidth())
}