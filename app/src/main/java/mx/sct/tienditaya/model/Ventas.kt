package mx.sct.tienditaya.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class Ventas(
    var producto: String,
    var cantidad: String,
    var precio: String
    )
