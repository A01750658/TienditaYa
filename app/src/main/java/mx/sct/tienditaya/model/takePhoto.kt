package mx.sct.tienditaya.model

import android.content.Context
import android.graphics.Bitmap
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.view.LifecycleCameraController
import androidx.core.content.ContextCompat

public fun takePhoto(controller: LifecycleCameraController, context: Context,
                      onPhotoTaken: (Bitmap) -> Unit){
    controller.takePicture(
        ContextCompat.getMainExecutor(context),
        object : ImageCapture.OnImageCapturedCallback() {
            override fun onCaptureSuccess(image: ImageProxy) {
                super.onCaptureSuccess(image)
                val bitmap = image.toBitmap()
                if (bitmap != null) {
                    recognizeTextFromBitmap(bitmap)
                } else {
                    println("Failed to convert ImageProxy to Bitmap")
                }
                image.close() // Don't forget to close the ImageProxy
                println("aaaaaaaaaa")
            }
            override fun onError(exception: ImageCaptureException) {
                super.onError(exception)
                println("bbbbbbbbbb")
            }
        }
    )
}