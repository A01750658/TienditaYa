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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import mx.sct.tienditaya.R

@Composable
fun Ventas(navController: NavHostController, modifier: Modifier = Modifier) {
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
                        .weight(1.5f),
                    textAlign = TextAlign.Center
                )
                VerticalDivider(color = Color.White, modifier = Modifier.height(40.dp))
                Text(
                    text = "Cantidad",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(1.3f),
                    textAlign = TextAlign.Center
                )
                VerticalDivider(color = Color.White, modifier = Modifier.height(40.dp))
                Text(
                    text = "Costo",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(0.9f),
                    textAlign = TextAlign.Center
                )
                VerticalDivider(color = Color.White, modifier = Modifier.height(40.dp))
                Text(
                    text = "Editar",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(1f),
                    textAlign = TextAlign.Center
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
                items(20) { index ->
                    Row {
                        Text(
                            text = "Producto ${index + 1}",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.White,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth()
                                .weight(1.5f),
                        )
                        VerticalDivider(color = Color.White, modifier = Modifier.height(40.dp))
                        Text(
                            text = "${index + 1}",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.White,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(5.dp)
                                .weight(1.3f),
                            textAlign = TextAlign.Center
                        )
                        VerticalDivider(color = Color.White, modifier = Modifier.height(40.dp))
                        Text(
                            text = "$${index + 1}",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.White,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(5.dp)
                                .weight(0.9f),
                            textAlign = TextAlign.Center
                        )
                        VerticalDivider(color = Color.White, modifier = Modifier.height(40.dp))
                        ElevatedButton(
                            onClick = { navController.navigate(Pantallas.RUTA_EDITAR_PRODUCTO_VENTA) },
                            modifier = Modifier
                                .height(35.dp)
                                .width(60.dp)
                                .weight(1f),

                            ) {
                            Icon(
                                imageVector = Icons.Filled.Create,
                                contentDescription = "Editar"
                            )
                        }
                        VerticalDivider(color = Color.White, modifier = Modifier.height(40.dp))
                    }
                    Divider(
                        color = Color.White, // Set the color of the divider
                        thickness = 1.dp, // Set the thickness of the divider
                        modifier = Modifier.padding(horizontal = 5.dp) // Add padding if needed
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(60.dp))
                }
            }
        }
        FloatingActionButton( onClick = { navController.navigate(Pantallas.RUTA_APP_HOME) }, modifier = Modifier.align(Alignment.BottomCenter)) {
            Text(text = "Añadir o Editar", modifier = Modifier.padding(10.dp), color = Color.White)
        }
    }
}