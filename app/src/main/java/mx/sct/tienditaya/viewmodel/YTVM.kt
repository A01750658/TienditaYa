package mx.sct.tienditaya.viewmodel

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.preferences.core.edit
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
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mx.sct.tienditaya.PreferencesKeys
import mx.sct.tienditaya.dataStore
import mx.sct.tienditaya.model.AppDatabase
import mx.sct.tienditaya.model.Fiados
import mx.sct.tienditaya.model.Inventario
import mx.sct.tienditaya.model.ModelConnection
import mx.sct.tienditaya.model.ProductInventory
import mx.sct.tienditaya.model.Ventas

class YTVM: ViewModel() {
    private val model = ModelConnection()
    val _estadoInventario = MutableStateFlow<ProductInventory>(ProductInventory(listOf()))
    val estadoInventario: StateFlow<ProductInventory> = _estadoInventario
    val _estadoFiados = MutableStateFlow<ProductInventory>(ProductInventory(listOf()))
    val estadoFiados: StateFlow<ProductInventory> = _estadoFiados

    private val _estadoInt: MutableStateFlow<Int> = MutableStateFlow(0)
    val estadoInt : StateFlow<Int> = _estadoInt

    private val _estadoListaProducto = MutableStateFlow<String>("")
    val estadoListaProducto: StateFlow<String> = _estadoListaProducto



    fun setListaProducto(aydua: String){
        _estadoListaProducto.value = aydua
        println("${_estadoListaProducto.value}")
    }


    suspend fun saveHashPasswordSync(context: Context) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.username_saved] = _estadoListaProducto.value
        }
    }

    fun saveHashPassword(context: Context) {
        runBlocking {
            saveHashPasswordSync(context)
            println("Hash guardado")
        }
    }

    suspend fun getHashPassword(context: Context): String? {
        val preferences = context.dataStore.data.first()
        return preferences[PreferencesKeys.username_saved]
    }

    fun getHashPasswordSync(context: Context): String? {
        return runBlocking {
            getHashPassword(context)
        }
    }

    fun clearListaProducto(){
        println("adasfjsallllllpooooooo${_estadoListaProducto.value}")
        //_estadoListaProducto.value.clear()
    }

    fun setEstadoInt(tipo:Int){
        _estadoInt.value = tipo
    }

    private val _estadoScanner : MutableStateFlow<MutableSet<String>> = MutableStateFlow(mutableSetOf<String>())
    val estadoScanner : StateFlow<MutableSet<String>> = _estadoScanner



    fun getInventario(){
        println("getInventario")
        println("BBBBBBB")
        viewModelScope.launch {
            _estadoInventario.value = model.getInventario()

        }
    }
    fun putInventario(Inventario: Inventario){
        viewModelScope.launch {
            model.putInventario(Inventario)
        }
    }

    fun postInventario(Inventario: Inventario){
        viewModelScope.launch {
            val r = model.postInventario(Inventario)
            println(r)

        }
    }
    fun postVenta(venta: Ventas) {
        viewModelScope.launch {
            val r = model.postVenta(venta)
            println(r)
        }
    }
    fun postCompra(compra: mx.sct.tienditaya.model.Compras) {
        viewModelScope.launch {
            val r = model.postCompra(compra)
            println(r)
        }
    }

    fun getFiados() {
        viewModelScope.launch {
            _estadoFiados.value = model.getFiados()
        }
    }

    fun postFiado(fiado: Fiados) {
        viewModelScope.launch {
            val r = model.postFiado(fiado)
            println(r)
        }
    }

    fun putFiado(fiado: Fiados) {
        viewModelScope.launch {
            val r = model.editFiado(fiado)
            println(r)
        }

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