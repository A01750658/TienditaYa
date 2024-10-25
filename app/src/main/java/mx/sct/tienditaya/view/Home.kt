package mx.sct.tienditaya.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import mx.sct.tienditaya.R

@Composable
fun Home(navController: NavHostController, modifier: Modifier = Modifier){
    Column(modifier = modifier.padding(horizontal = 16.dp)){
        BotonPantallas(onClick = { navController.navigate(Pantallas.RUTA_VENTAS) }, imagen = R.drawable.descarga, nombre ="Ventas" )
    }
}