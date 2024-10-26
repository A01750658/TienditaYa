package mx.sct.tienditaya.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Inventario(
    @PrimaryKey (autoGenerate = true)
    val id: Int = 0,
    val nombre_producto: String,
    val cantidad_producto: Int
)
