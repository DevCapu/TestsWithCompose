package br.com.devcapu.jetpackcomposetest.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.devcapu.jetpackcomposetest.R

@Composable
fun AppBar() {
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
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body2
        )
    }
}