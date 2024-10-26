package mx.sct.tienditaya.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Fiados(
    val nombre: String,
    val deuda: Float
)
