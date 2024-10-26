package mx.sct.tienditaya.model

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.room.Room

fun DatabaseFunc(applicationContext: Context){
 val db = Room.databaseBuilder(
     applicationContext,
     AppDatabase::class.java, "databaseTY"
 ).build()
}