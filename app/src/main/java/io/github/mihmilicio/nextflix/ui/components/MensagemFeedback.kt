package io.github.mihmilicio.nextflix.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun MensagemFeedback(
    titulo: String, icone: ImageVector?, corpo: String? = null
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        icone?.let {
            Icon(imageVector = it, contentDescription = null, modifier = Modifier.size(48.dp))
            Spacer(modifier = Modifier.size(16.dp))
        }
        Text(
            text = titulo, style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
        )
        corpo?.let {
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = it,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
            )
        }
    }
}