package mx.sct.tienditaya.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class Inventario(
    val producto: String,
    val cantidad: Int
)
