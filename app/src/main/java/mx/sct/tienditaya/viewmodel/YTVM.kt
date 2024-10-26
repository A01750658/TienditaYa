package mx.sct.tienditaya.viewmodel

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.vertexai.vertexAI
import kotlinx.coroutines.launch

class YTVM: ViewModel() {
    val generativeModel = Firebase.vertexAI.generativeModel("gemini-1.5-flash")

    fun generateVertexResponse(prompt: String){
        viewModelScope.launch{
            val response = generativeModel.generateContent("Write a story about the green robot")
        }
    }
}