package mx.sct.tienditaya.viewmodel

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.vertexai.type.content
import com.google.firebase.vertexai.vertexAI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import mx.sct.tienditaya.model.AppDatabase
import mx.sct.tienditaya.model.Inventario

class YTVM: ViewModel() {
    private lateinit var db: AppDatabase
    val _estadoInventario = MutableStateFlow<List<Inventario>>(emptyList())
    val estadoInventario: StateFlow<List<Inventario>> = _estadoInventario


    fun database(database: AppDatabase){
        db = database
    }

    fun getInventario(){
        println("getInventario")
        println("BBBBBBB")
        viewModelScope.launch {
            val inventario = db.inventarioDao().getAll()

        }
    }

    fun initDatabase(context: Context){
        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "databaseTY"
        ).build()

    }

    fun generateVertexResponseText(image: Bitmap){
        viewModelScope.launch{
            val response = generativeModel.generateContent(
                content{
                   image(image)
                    text("Podrías porfavor reconocer el texto de esta imagen y devolverlo en orden?")
                }
            )
        }
    }
}