package com.example.collectionjanuary2020.builder.default_alert

import android.content.Context
import androidx.appcompat.app.AlertDialog

data class Alert(
    val title: String,
    val description: String?,
    val alertContext: Context,
    val positiveButton: () -> Unit,
    val negativeButton: () -> Unit
) {
    constructor(builder: Builder) : this(
        builder.title,
        builder.description,
        builder.alertContext,
        builder.positiveButton,
        builder.negativeButton
    )

    init {
        AlertDialog.Builder(alertContext)
            .setTitle(title)
            .setMessage(description)
            .setPositiveButton("Yes") { _, _ -> positiveButton.invoke() }
            .setNegativeButton("No") { _, _ -> negativeButton.invoke() }.show()
    }

    companion object {
        inline fun alert(block: Builder.() -> Unit) = Builder().apply(block).build()
    }


    class Builder {
        lateinit var title: String
        lateinit var description: String
        lateinit var alertContext: Context
        lateinit var positiveButton: () -> Unit
        lateinit var negativeButton: () -> Unit
        fun build() =
            Alert(this)
    }
}