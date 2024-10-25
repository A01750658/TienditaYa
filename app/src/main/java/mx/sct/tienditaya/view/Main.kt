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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(navController: NavHostController) {
    if (navController.currentBackStackEntryAsState().value?.destination?.route == Pantallas.RUTA_APP_HOME) {
        TopAppBar(
            title = {
                Text(
                    text = "TienditaYa",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 40.sp),
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.onTertiary,
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        )
    } else if (navController.currentBackStackEntryAsState().value?.destination?.route == Pantallas.RUTA_VENTAS) {
        TopAppBar(
            title = {
                Text(
                    text = "Generar venta",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 40.sp),
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.onTertiary,
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onTertiary
                    )
                }
            }
        )
    } else if (navController.currentBackStackEntryAsState().value?.destination?.route == Pantallas.RUTA_ANADIR_PRODUCTO) {
        TopAppBar(
            title = {
                Text(
                    text = "Añadir a Inventario",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 40.sp),
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.onTertiary,
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onTertiary
                    )
                }
            }
        )
    } else if (navController.currentBackStackEntryAsState().value?.destination?.route == Pantallas.RUTA_INVENTARIO) {
        TopAppBar(
            title = {
                Text(
                    text = "Inventario",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 40.sp),
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.onTertiary,
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onTertiary
                    )
                }
            }
        )
    }
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
            AnadirProducto(navController)
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
