package mx.sct.tienditaya.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface VertexAIService {
    @Headers("Content-Type: application/json")
    @POST("v1/projects/{project-id}/locations/{location}/endpoints/{endpoint-id}:predict")
    fun sendPrompt(@Body requestBody: String): Call<String>
    //fun sendPrompt(@Body requestBody: RequestBody): Call<ResponseBody>
}