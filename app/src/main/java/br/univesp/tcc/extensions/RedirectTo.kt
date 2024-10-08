package br.univesp.tcc.extensions

import android.content.Context
import android.content.Intent

fun Context.RedirectTo(
    clazz: Class<*>,
    intent: Intent.() -> Unit = {}
) {
    Intent(this, clazz).apply {
        intent()
        startActivity(this)
    }
}