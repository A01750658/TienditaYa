package mx.sct.tienditaya.view

import android.graphics.Bitmap
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions

fun recognizeTextFromBitmap(bitmap: Bitmap) {
    val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
    val image = InputImage.fromBitmap(bitmap, 0)

    recognizer.process(image)
        .addOnSuccessListener { visionText ->
            // Handle successful text recognition here
            val resultText = visionText.text
            // Do something with the recognized text
            println("Recognized text: $resultText")
        }
        .addOnFailureListener { e ->
            // Handle any errors here
            e.printStackTrace()
        }
}
