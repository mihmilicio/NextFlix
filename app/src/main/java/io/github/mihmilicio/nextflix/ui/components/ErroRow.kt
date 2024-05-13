package io.github.mihmilicio.nextflix.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.mihmilicio.nextflix.R
import io.github.mihmilicio.nextflix.ui.theme.NextFlixTheme

@Composable
fun ErroRow(
    modifier: Modifier = Modifier,
    mensagem: String? = null,
    onClickRetry: () -> Unit
) {
    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.errorContainer)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f, fill = true)) {
            Text(
                text = mensagem ?: stringResource(id = R.string.erro_mensagem_padrao),
                color = MaterialTheme.colorScheme.error,
                maxLines = 2,
                modifier = Modifier.padding(end = 4.dp)
            )
        }
        Column(modifier = Modifier.wrapContentWidth()) {
            IconButton(onClick = onClickRetry) {
                Icon(
                    tint = MaterialTheme.colorScheme.error,
                    imageVector = Icons.Outlined.Refresh,
                    contentDescription = stringResource(R.string.btn_recarregar_alt_text)
                )
            }
        }

    }
}

@Preview
@Composable
fun ErroRowPreview() {
    NextFlixTheme {
        ErroRow { TODO() }
    }
}