package mx.sct.tienditaya.model

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Compras::class, Ventas::class, Inventario::class, Fiados::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun comprasDao(): ComprasDao
    abstract fun ventasDao(): VentasDao
    abstract fun inventarioDao(): InventarioDao
    abstract fun fiadosDao(): FiadosDao
}