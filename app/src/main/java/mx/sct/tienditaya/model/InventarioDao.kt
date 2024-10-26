package mx.sct.tienditaya.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import mx.sct.tienditaya.view.Inventario

@Dao
interface InventarioDao {
    @Query("SELECT * FROM inventario")
    fun getAll(): Flow<List<Inventario>>

    @Insert
    fun insertAll(vararg inventarios: Inventario)

    @Update
    suspend fun update(inventario: Inventario)

}