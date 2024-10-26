package mx.sct.tienditaya.view

import android.content.Context
import android.graphics.Bitmap
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import mx.sct.tienditaya.view.Camara
import androidx.compose.ui.Alignment
import androidx.core.content.ContextCompat
import androidx.compose.ui.platform.LocalContext

@Composable
fun CamaraHelper(context: Context) {
    val controller = remember {
        LifecycleCameraController(context).apply {
            setEnabledUseCases(
                CameraController.IMAGE_CAPTURE or
                        CameraController.VIDEO_CAPTURE
            )
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Camara(
            controller = controller,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween // Arranges children with space between them
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = {
                    takePhoto(controller, context, onPhotoTaken = {})
                }
                ){
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star",
                        tint = Color.White
                    )
                }
            }
        }
    }
}

private fun takePhoto(controller: LifecycleCameraController, context: Context,
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