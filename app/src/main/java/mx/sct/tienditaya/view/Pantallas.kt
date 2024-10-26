package mx.sct.tienditaya.view

import androidx.compose.ui.graphics.vector.ImageVector

sealed class Pantallas (
    val ruta: String,
    val etiqueta: String,
    val icono: ImageVector
){
    companion object {
        const val RUTA_APP_HOME = "ruta_app_home"
        const val RUTA_ANADIR_PRODUCTO = "ruta_anadir_producto"
        const val RUTA_VENTAS = "ruta_ventas"
        const val RUTA_INVENTARIO = "ruta_inventario"
        const val RUTA_FIADOS = "ruta_fiados"
        const val RUTA_CHECAR_FIADOS = "ruta_checar_fiados"
    }
}