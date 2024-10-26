package mx.sct.tienditaya.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FiadosDao {
    @Query ("SELECT * FROM fiados")
    fun getAll(): List<Fiados>

    @Insert
    fun insertAll(vararg fiado: Fiados)
}