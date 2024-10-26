package mx.sct.tienditaya.viewmodel

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.google.firebase.Firebase
import com.google.firebase.vertexai.type.content
import com.google.firebase.vertexai.vertexAI
import kotlinx.coroutines.launch
import mx.sct.tienditaya.model.AppDatabase

class YTVM: ViewModel() {
    val generativeModel = Firebase.vertexAI.generativeModel("gemini-1.5-flash")

    fun generateVertexResponseOrder(prompt: String){
        viewModelScope.launch{
            val response = generativeModel.generateContent("Write a story about the green robot")
        }
    }


    fun initDatabase(context: Context){
        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "databaseTY"
        ).build()

    }
    /**fun generateVertexResponseText(image: Bitmap){
        viewModelScope.launch{
            val response = generativeModel.generateContent(
                content{
                   image(image)
                    text("Podrías porfavor reconocer el texto de esta imagen y devolverlo en orden?")
                }
            )
        }
    }*/
}