package com.worldcrisis.whitehouse

import android.app.Activity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView

class MainActivity : Activity() {

    private var webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            val wv = WebView(this)
            webView = wv

            wv.settings.javaScriptEnabled = true
            wv.settings.domStorageEnabled = true
            wv.settings.allowFileAccess = true
            wv.settings.allowContentAccess = true

            wv.webViewClient = WebViewClient()
            wv.webChromeClient = WebChromeClient()

            setContentView(wv)
            wv.loadUrl("file:///android_asset/index.html")

        } catch (e: Throwable) {
            val error = TextView(this)
            error.text = "WHITE HOUSE - ERRO DE INICIALIZACAO\n\n" +
                    e.javaClass.name + "\n\n" +
                    (e.message ?: "Sem mensagem de erro")
            error.textSize = 16f
            error.setPadding(30, 60, 30, 30)
            setContentView(error)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val wv = webView
        if (wv != null && wv.canGoBack()) {
            wv.goBack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        webView?.destroy()
        webView = null
        super.onDestroy()
    }
}
