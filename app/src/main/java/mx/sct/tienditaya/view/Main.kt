package mx.sct.tienditaya.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import mx.sct.tienditaya.R
import mx.sct.tienditaya.ui.theme.TienditaYaTheme
import mx.sct.tienditaya.viewmodel.YTVM

@Composable
fun Main( viewModel: YTVM, modifier: Modifier = Modifier,){
    val navController = rememberNavController()
    TienditaYaTheme {
        Scaffold(topBar = {AppTopBar(navController)}){
                innerPadding ->
            AppNavHost(viewModel,navController,modifier.padding(innerPadding))
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
    } else if (navController.currentBackStackEntryAsState().value?.destination?.route == Pantallas.RUTA_FIADOS) {
        TopAppBar(
            title = {
                Text(
                    text = "Fiados",
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
    else if (navController.currentBackStackEntryAsState().value?.destination?.route == Pantallas.RUTA_CHECAR_FIADOS) {
        TopAppBar(
            title = {
                Text(
                    text = "Verificar Fiados",
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
    }else if (navController.currentBackStackEntryAsState().value?.destination?.route == Pantallas.RUTA_EDITAR_PRODUCTO) {
        TopAppBar(
            title = {
                Text(
                    text = "Editar Información del Producto",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 35.sp),
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
    }else if (navController.currentBackStackEntryAsState().value?.destination?.route == Pantallas.RUTA_EDITAR_FIADO) {
        TopAppBar(
            title = {
                Text(
                    text = "Editar Información Nueva del Fiado",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 35.sp),
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
    }else if (navController.currentBackStackEntryAsState().value?.destination?.route == Pantallas.RUTA_EDITAR_PRODUCTO_VENTA) {
        TopAppBar(
            title = {
                Text(
                    text = "Editar Información del Producto para Venta",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 35.sp),
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
    }else if (navController.currentBackStackEntryAsState().value?.destination?.route == Pantallas.RUTA_CHAT_BOT) {
        TopAppBar(
            title = {
                Text(
                    text = "Aprende a usar nuestra aplicación",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 20.sp),
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
    }else if (navController.currentBackStackEntryAsState().value?.destination?.route == Pantallas.RUTA_CAMARA) {
        TopAppBar(
            title = {
                Text(
                    text = "Texto que cambia con un estado ahhhh",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 20.sp),
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
fun AppNavHost(viewModel: YTVM, navController: NavHostController, modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center,modifier = Modifier
        .fillMaxSize()
        .paint(
            painterResource(id = R.drawable.tienda_2),
            contentScale = ContentScale.FillBounds
        )
    ) {
        NavHost(
            navController = navController,

            startDestination = Pantallas.RUTA_APP_HOME,
            modifier = modifier,
        ) {

            composable(Pantallas.RUTA_APP_HOME) {
                Home(viewModel = viewModel, navController = navController,)
            }
            composable(Pantallas.RUTA_ANADIR_PRODUCTO) {
                AnadirProducto(navController)
            }
            composable(Pantallas.RUTA_VENTAS) {
                Ventas(navController)
            }
            composable(Pantallas.RUTA_INVENTARIO) {
                Inventario(viewModel)
            }
            composable(Pantallas.RUTA_FIADOS) {
                Fiados(viewModel,navController)
            }
            composable(Pantallas.RUTA_CHECAR_FIADOS) {
                ChecarFiados(navController)
            }
            composable(Pantallas.RUTA_EDITAR_PRODUCTO) {
                EditarProducto(navController)
            }
            composable(Pantallas.RUTA_EDITAR_FIADO) {
                EditarFiado(navController)
                }
            composable(Pantallas.RUTA_EDITAR_PRODUCTO_VENTA) {
                EditarProductoVenta(navController)
            }
            composable(Pantallas.RUTA_CHAT_BOT) {
                ChatBot()
            }
            composable(Pantallas.RUTA_CAMARA){
                CamaraHelper(context = LocalContext.current)
            }
        }
    }
}

