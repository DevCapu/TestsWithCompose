package br.com.devcapu.jetpackcomposetest.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import br.com.devcapu.jetpackcomposetest.R
import br.com.devcapu.jetpackcomposetest.SearchUiState


@Composable
fun SearchSection(
    uiState: SearchUiState = SearchUiState(),
    onCepChanged: (String) -> Unit = { },
    onButtonClicked: () -> Unit =  { },
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
