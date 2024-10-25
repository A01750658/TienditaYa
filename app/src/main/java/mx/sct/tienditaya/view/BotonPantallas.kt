package mx.sct.tienditaya.view

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BotonPantallas(onClick: () -> Unit, imagen: Int, nombre: String, modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    Column(
        modifier = modifier
            .padding(vertical = 10.dp)
            .height(270.dp)
            .padding(horizontal = 5.dp)
            .border(1.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(25)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ElevatedButton(
            onClick = { onClick() },
            shape = RoundedCornerShape(25),
            modifier = modifier
                .height(270.dp)
                .width(if (screenWidth < 370) 180.dp else (screenWidth / 2.30).dp)
                .padding(horizontal = 3.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Image(
                painter = painterResource(id = imagen),
                contentDescription = "Elemento",
                modifier = modifier
                    .height(160.dp)
                    .fillMaxWidth()
            )
                Text(
                    text = nombre,
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .padding(top = 5.dp).fillMaxWidth(),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 20.sp)
                )
            }
        }
    }
}
