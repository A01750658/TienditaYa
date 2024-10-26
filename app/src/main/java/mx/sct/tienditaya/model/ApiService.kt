package mx.sct.tienditaya.model

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiService {
    @Headers("User-Agent: Retrofit")
    @GET("/inventario/data")
    suspend fun getInventario(): ProductInventory
    @Headers("User-Agent: Retrofit")
    @PUT("/inventario/data")
    suspend fun updateInventario(@Body inventario: Inventario):ResponseFormat
    @Headers("User-Agent: Retrofit")
    @POST("/inventario/data")
    suspend fun postInventario(@Body inventario: Inventario):ResponseFormat
    @Headers("User-Agent: Retrofit")
    @POST("/venta/data")
    suspend fun postVenta(@Body venta: Ventas):ResponseFormat
    @Headers("User-Agent: Retrofit")
    @POST("/compra/data")
    suspend fun postCompra(@Body compra: Compras):ResponseFormat
    @Headers("User-Agent: Retrofit")
    @GET("fiado/data")
    suspend fun getFiados(): ProductInventory
    @Headers("User-Agent: Retrofit")
    @POST("/fiado/data")
    suspend fun postFiado(@Body fiado: Fiados):ResponseFormat
    @Headers("User-Agent: Retrofit")
    @PUT("/fiado/data")
    suspend fun updateFiado(@Body fiado: Fiados):ResponseFormat





}