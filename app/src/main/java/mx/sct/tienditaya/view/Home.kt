package mx.sct.tienditaya.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import mx.sct.tienditaya.R

@Composable
fun Home(navController: NavHostController, modifier: Modifier = Modifier){
    Box(modifier= Modifier.fillMaxSize().paint(painterResource(id= R.drawable.tienda_2),
        contentScale = ContentScale.FillBounds)){
        Column(modifier = modifier.padding(horizontal = 20.dp)) {
            Row() {
                BotonPantallas(
                    onClick = { navController.navigate(Pantallas.RUTA_VENTAS) },
                    imagen = R.drawable.ventas,
                    nombre = "Ventas"
                )
                BotonPantallas(
                    onClick = { navController.navigate(Pantallas.RUTA_INVENTARIO) },
                    imagen = R.drawable.inventario,
                    nombre = "Inventario"
                )
            }
            Row() {
                BotonPantallas(
                    onClick = { navController.navigate(Pantallas.RUTA_FIADOS) },
                    imagen = R.drawable.fiados,
                    nombre = "Fiados"
                )
                BotonPantallas(
                    onClick = { navController.navigate(Pantallas.RUTA_ANADIR_PRODUCTO) },
                    imagen = R.drawable.camion,
                    nombre = "Agregar Prodcutos"
                )

            }


        }
    }
}



