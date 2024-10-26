package mx.sct.tienditaya.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ModelConnection {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://10.48.105.198:8000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service by lazy{

        retrofit.create(ApiService::class.java)
    }

    suspend fun getInventario(): ProductInventory {
        try {
            val response = service.getInventario()
            println(response)
            return response
        }catch (e: Exception){
            println("EXCEPCIOOOOOON")
            println(e.message)
            return  ProductInventory(emptyList())
        }
    }

    suspend fun putInventario(Inventario: Inventario):ResponseFormat{
        try{
            val response = service.updateInventario(Inventario)
            return response
        } catch (e: Exception){
            println("EXCEPCIOOOOOON")
            println(e.message)
            return ResponseFormat(e.toString())

        }
    }
    suspend fun postInventario(Inventario: Inventario):ResponseFormat{
        try{
            val response = service.postInventario(Inventario)
            return response
        } catch (e: Exception) {
            println("EXCEPCIOOOOOON")
            println(e.message)
            return ResponseFormat(e.toString())
        }
    }
    suspend fun postVenta(venta: Ventas):ResponseFormat{
        try{
            val response = service.postVenta(venta)
            return response
        } catch (e: Exception) {
            println("EXCEPCIOOOOOON")
            println(e.message)
            return ResponseFormat(e.toString())
        }
    }
    suspend fun postCompra(compra: Compras):ResponseFormat{
        try{
            val response = service.postCompra(compra)
            return response
        } catch (e: Exception) {
            println("EXCEPCIOOOOOON")
            println(e.message)
            return ResponseFormat(e.toString())
        }
    }

    suspend fun getFiados(): ProductInventory{
        try {
            val response = service.getFiados()
            return response
        }catch (e: Exception){
            println("EXCEPCIOOOOOON")
            println(e.message)
            return  ProductInventory(emptyList())
        }

    }

    suspend fun postFiado(fiado: Fiados):ResponseFormat{
        try{
            val response = service.postFiado(fiado)
            return response
        } catch (e: Exception) {
            println("EXCEPCIOOOOOON")
            println(e.message)
            return ResponseFormat(e.toString())
        }
    }
    suspend fun editFiado(fiado: Fiados):ResponseFormat {
        try {
            val response = service.updateFiado(fiado)
            return response
        } catch (e: Exception) {
            println("EXCEPCIOOOOOON")
            println(e.message)
            return ResponseFormat(e.toString())
        }
    }
}