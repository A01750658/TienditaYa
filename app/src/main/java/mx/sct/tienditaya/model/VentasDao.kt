package mx.sct.tienditaya.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface VentasDao {
    @Query("SELECT * FROM ventas")
    fun getAll(): List<Ventas>

    @Insert
    fun insertAll(vararg venta: Ventas)
}