package mx.sct.tienditaya.view

import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import mx.sct.tienditaya.Greeting
import mx.sct.tienditaya.ui.theme.TienditaYaTheme

@Composable
fun Main(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    TienditaYaTheme {
        Scaffold(topBar = {AppTopBar(navController)}){
                innerPadding ->
            AppNavHost(navController,modifier.padding(innerPadding))
        }
    }
}

/**
 * Función de la top bar y la mestra en las pantallas necesarias
 * @author Alan Vega
 * @author Santiago Chevez
 * @author Andrés Cabrera
 * @param navController Controlador de navegación de la aplicación.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(navController: NavHostController) {
    TopAppBar(
        title = {
            Text(text = "TienditaYa",
                textAlign = TextAlign.Left,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.onTertiary,
                fontWeight = FontWeight.Bold)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary),
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }){
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onTertiary)
            }
        }
    )
}


@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,

        startDestination = Pantallas.RUTA_APP_HOME,
        modifier = modifier,
    ) {
        composable(Pantallas.RUTA_APP_HOME) {
            Home(navController)
        }
        composable(Pantallas.RUTA_ANADIR_PRODUCTO) {
            AnadirProducto()
        }
        composable(Pantallas.RUTA_VENTAS) {
            Ventas()
        }
        composable(Pantallas.RUTA_INVENTARIO) {
            Inventario()
        }
        composable(Pantallas.RUTA_FIADOS) {
            Fiados()
        }
    }
}
