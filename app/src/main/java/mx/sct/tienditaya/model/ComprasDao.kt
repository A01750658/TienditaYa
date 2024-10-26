package mx.sct.tienditaya.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ComprasDao {
    @Query("SELECT * FROM compras")
    fun getAll(): List<Compras>

   @Insert
   fun insertAll(vararg compra: Compras)
}