package mx.sct.tienditaya.view

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun ChatBot() {

    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()

                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                settings.setSupportZoom(true)
            }
        },
        update = { webView ->
            webView.loadUrl("https://web-chat.global.assistant.watson.appdomain.cloud/preview.html?backgroundImageURL=https%3A%2F%2Fus-south.assistant.watson.cloud.ibm.com%2Fpublic%2Fimages%2Fupx-4d7c2db8-0374-4459-bed0-ac2d254142e6%3A%3A504c57f5-ed2d-4b05-9024-f2efd4920442&integrationID=a0441454-850e-4ed3-841a-2b03bd06a570&region=us-south&serviceInstanceID=4d7c2db8-0374-4459-bed0-ac2d254142e6")
        }
    )
}