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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import mx.sct.tienditaya.R
import mx.sct.tienditaya.viewmodel.YTVM

@Composable
fun Inventario(viewModel: YTVM, modifier: Modifier = Modifier){
    val estadoInventario by viewModel.estadoInventario.collectAsState()
    var text by remember { mutableStateOf("") }
    Box(contentAlignment = Alignment.Center,modifier = Modifier
        .fillMaxSize()
        .paint(
            painterResource(id = R.drawable.tienda_2),
            contentScale = ContentScale.FillBounds
        )) {
        Column {
            InputSearch(text = text, onValueChange = { text = it }, keyBoardType = KeyboardType.Text)
            Column(
                modifier = modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.9f))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp)
                ) {
                    Text(
                        text = "   Producto",
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(3f),
                        color = Color.White,
                        textAlign = TextAlign.Left,
                        fontSize = 24.sp
                    )
                    Text(
                        text = "Cantidad",
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(2f),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                HorizontalDivider(color = Color.White)
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    items(estadoInventario.response.size) { product ->
                        if(text.isEmpty() || estadoInventario.response[product][1].contains(text, ignoreCase = true)) {
                            Spacer(modifier = Modifier.height(16.dp))
                            Row() {
                                Text(
                                    text = estadoInventario.response[product][1],
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(3f),
                                    color = Color.White,
                                    textAlign = TextAlign.Left,
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = estadoInventario.response[product][2],
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(2f),
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    fontSize = 20.sp
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            HorizontalDivider(color = Color.White)
                        }
                    }
                }
            }
        }
    }
}