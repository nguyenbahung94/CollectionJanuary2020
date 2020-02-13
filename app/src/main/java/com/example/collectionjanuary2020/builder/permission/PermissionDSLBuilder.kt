package com.example.collectionjanuary2020.builder.permission

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class PermissionDSLBuilder(
    val activityContext: Context,
    val permissions: Array<String>?,
    val onPermissionGranted: () -> Unit,
    val onPermissionDenied: () -> Unit
) {

    constructor(builder: Builder) : this(
        builder.activityContext,
        builder.permissions,
        builder.onPermissionGranted,
        builder.onPermissionDenied
    )

    companion object {
        fun Activity.getPermissions(block: Builder.() -> Unit) = Builder(this).apply(block).build()

        fun Fragment.getPermissions(block: Builder.() -> Unit) =
            Builder(this.requireActivity()).apply(block).build()
    }

    init {
        if (permissions != null && ContextCompat.checkSelfPermission(
                activityContext,
                permissions[0]
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            PermissionActivity.intialize(object : OnRequestCallBack {
                override fun onPermissionGranted() {
                    onPermissionGranted.invoke()
                }

                override fun onPermissionDenied() {
                    onPermissionDenied.invoke()
                }

            })
            val intent = Intent(activityContext, PermissionActivity::class.java)
            val bundle = Bundle().apply {
                putStringArray("permissions", permissions)
            }
            intent.putExtras(bundle)

            activityContext.startActivity(intent)

        }
    }

    class Builder(context: Context) {
        var activityContext: Context = context
        lateinit var permissions: Array<String>
        lateinit var onPermissionGranted: () -> Unit
        lateinit var onPermissionDenied: () -> Unit

        fun build() = PermissionDSLBuilder(this)
    }

}