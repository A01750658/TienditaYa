package mx.sct.tienditaya.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.sct.tienditaya.R

@Composable
fun Ventas(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            /*.paint(
                painterResource(id = R.drawable.tienda_2),
                contentScale = ContentScale.FillBounds
            )*/
    ) {
        Column(modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(16.dp))
            .background(color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.9f))
        ) {
            Text(
                text = "Se encontraron los siguientes productos",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(5.dp))
            HorizontalDivider(color = Color.White)

            // Header row (appears only once)
            Row {
                Text(
                    text = "Producto",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(1.5f)
                )


                Text(
                    text = "Cantidad",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(1.3f)
                )

                Text(
                    text = "Costo",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(0.9f)
                )

                Text(
                    text = "Editar",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(1f),
                )


            }

            // Repeating "Producto" column
            LazyColumn {
                item {
                    Divider(
                        color = Color.White,
                        thickness = 1.dp,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                }

                items(10) { index ->
                    Text(
                        text = "Producto ${index + 1}",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()


                    )
                    Divider(
                        color = Color.White, // Set the color of the divider
                        thickness = 1.dp, // Set the thickness of the divider
                        modifier = Modifier.padding(horizontal = 5.dp) // Add padding if needed
                    )
                }
            }
        }
    }
}