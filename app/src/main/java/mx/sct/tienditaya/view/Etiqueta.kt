package mx.sct.tienditaya.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Etiqueta(texto: String, modifier: Modifier = Modifier, color: Color = MaterialTheme.colorScheme.onTertiary, padding: Int = 16) {

    Text(
        text = texto.uppercase(),
        textAlign = TextAlign.Left,
        style = MaterialTheme.typography.bodyLarge,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = color,
        modifier = modifier
            .padding(horizontal = padding.dp)
            .fillMaxWidth()
    )

}