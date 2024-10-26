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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import mx.sct.tienditaya.R


@Composable
fun Fiados(navigationController: NavHostController, modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center,modifier = Modifier
        .fillMaxSize()
        .paint(
            painterResource(id = R.drawable.tienda_2),
            contentScale = ContentScale.FillBounds
        )) {
        Box{
            Column(
                modifier = modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.9f))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp)
                ) {
                    Text(
                        text = "   Persona",
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(4f),
                        color = Color.White,
                        textAlign = TextAlign.Left,
                        fontSize = 24.sp
                    )
                    VerticalDivider(color = Color.White, modifier = Modifier.height(30.dp))
                    Text(
                        text = "Deuda",
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(2f),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp
                    )


                }
                HorizontalDivider(color = Color.White)
                LazyColumn(modifier = Modifier.padding(start = 10.dp)) {
                    items(30) { i ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        ) {
                            Text(
                                text = "Nombre $i",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(4f),
                                color = Color.White,
                                textAlign = TextAlign.Left,
                                fontSize = 20.sp
                            )
                            VerticalDivider(color = Color.White, modifier = Modifier.height(40.dp))
                            Text(
                                text = "$$i",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(2f),
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp
                            )

                        }
                        HorizontalDivider(color = Color.White)
                    }
                    item {
                        Spacer(modifier = Modifier.height(40.dp))
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            FloatingActionButton( onClick = { navigationController.navigate(Pantallas.RUTA_CHECAR_FIADOS) }, modifier = Modifier.align(Alignment.BottomCenter)) {
                Text(text = "Añadir o Editar", modifier = Modifier.padding(10.dp), color = Color.White)
            }
        }
    }
}