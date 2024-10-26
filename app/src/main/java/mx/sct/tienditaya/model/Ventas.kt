package mx.sct.tienditaya.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class Ventas(
    val producto: String,
    val cantidad: Int,
    val precio: Float
    )
