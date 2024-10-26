package mx.sct.tienditaya.viewmodel

import com.google.firebase.Firebase
import com.google.firebase.vertexai.vertexAI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

val generativeModel = Firebase.vertexAI.generativeModel("gemini-1.5-flash")
fun generateVertexResponseOrder(prompt: String, scope: CoroutineScope){
    scope.launch{
        val response = generativeModel.generateContent("Write a story about the green robot")
    }
}