package mx.sct.tienditaya.model

import android.graphics.Bitmap
import androidx.navigation.NavHostController
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import mx.sct.tienditaya.view.Pantallas
import mx.sct.tienditaya.viewmodel.YTVM

fun recognizeTextFromBitmap(bitmap: Bitmap, idForo: String, navController: NavHostController) {
    val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
    val image = InputImage.fromBitmap(bitmap, 0)
    val YTVM = YTVM()
    var prods = mutableListOf<Ventas>()

    recognizer.process(image)
        .addOnSuccessListener { visionText ->
            // Handle successful text recognition here
            val resultText = visionText.text
            println(resultText)
            val lines = resultText.split("\n")
            // Do something with the recognized text
            val products = mutableListOf<List<String>>()

            for (line in lines) {
                products.add(line.split(" "))
            }

            if (idForo == "1") {
                for (i in products) {
                    var Venta = Ventas("0","0","0")
                    if (i.size == 3) {
                        Venta.producto = i[0]
                        Venta.cantidad = i[1]
                        Venta.precio = i[2]
                    }
                    prods.add(Venta)
                }
                YTVM.setListaProducto(prods)
                navController.navigate(Pantallas.RUTA_VENTAS)
                //YTVM.clearListaProducto()
            }
            if (idForo == "2") {
                for (i in products) {
                    if (i.size == 2) {
                        //YTVM.appendListaProducto(i)
                    }
                }
                //YTVM.clearListaProducto()
            }
            if (idForo == "3"){
                for (i in products) {
                    if (i.size == 2) {
                        //YTVM.appendListaProducto(i)
                    }
                }
                //YTVM.clearListaProducto()
            }

        }
        .addOnFailureListener { e ->
            // Handle any errors here
            e.printStackTrace()
        }
}
