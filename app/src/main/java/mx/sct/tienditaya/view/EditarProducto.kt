package mx.sct.tienditaya.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import mx.sct.tienditaya.R

@Composable
fun EditarProducto(navigationController: NavHostController, modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center,modifier = Modifier
        .fillMaxSize()
        .paint(
            painterResource(id = R.drawable.tienda_2),
            contentScale = ContentScale.FillBounds
        )) {
        Box {
            Column(
                modifier = modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.9f))
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Etiqueta(texto = "Producto")
                InputTexto(text = "", onValueChange = {})
                Etiqueta(texto = "Cantidad")
                InputTexto(text = "", onValueChange = {})
                Etiqueta(texto = "Costo")
                InputTexto(text = "", onValueChange = {})
                Spacer(modifier = Modifier.height(16.dp))
                ElevatedButton(onClick = {
                    navigationController.navigateUp()
                },
                    Modifier
                        .padding(horizontal = 100.dp)
                        .padding(bottom = 16.dp)
                    //.background(MaterialTheme.colorScheme.tertiary)
                    ,colors= ButtonDefaults.elevatedButtonColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onTertiary
                    )
                ){
                    Text(
                        text = "Acceder",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                }
            }
        }
    }
}
