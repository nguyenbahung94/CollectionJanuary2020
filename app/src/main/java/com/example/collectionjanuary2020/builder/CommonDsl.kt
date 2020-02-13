package com.example.collectionjanuary2020.builder

import android.app.Activity
import android.app.AlertDialog

inline fun Activity.Dialog(block: AlertDialog.Builder.() -> Unit) {
    AlertDialog.Builder(this).apply(block).create()
}

val Any.TAG: String
    get() {
        val tag = javaClass.simpleName
        return if (tag.length <= 23) tag else tag.substring(0, 23)
    }