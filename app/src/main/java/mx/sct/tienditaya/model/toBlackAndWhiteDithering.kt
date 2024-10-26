package mx.sct.tienditaya.model

import android.graphics.Bitmap
import android.graphics.Color

fun toBlackAndWhiteDithering(bitmap: Bitmap, dithering: Boolean): Bitmap {
    val width = bitmap.width
    val height = bitmap.height
    val bwBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)

    for (y in 0 until height) {
        for (x in 0 until width) {
            val pixel = bitmap.getPixel(x, y)
            val gray = (Color.red(pixel) * 0.3 + Color.green(pixel) * 0.59 + Color.blue(pixel) * 0.11).toInt()
            val bwColor = if (gray > 128) Color.WHITE else Color.BLACK
            bwBitmap.setPixel(x, y, bwColor)
        }
    }

    return bwBitmap
}
