package mx.sct.tienditaya.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ventas(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "nombre_producto") val nombreProducto: String,
    @ColumnInfo(name = "cantidad_producto") val cantidadProducto: Int,
    @ColumnInfo(name = "precio_venta") val precioVenta: Float
    )
