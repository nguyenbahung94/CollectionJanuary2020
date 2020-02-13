package com.example.collectionjanuary2020.builder

import android.Manifest
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.collectionjanuary2020.R
import com.example.collectionjanuary2020.builder.bottom_sheetdialog.BottomSheetDSLBuilder.Companion.bottomSheetDialog
import com.example.collectionjanuary2020.builder.custom_Alert.AlertData
import com.example.collectionjanuary2020.builder.custom_Alert.CustomAlert.Companion.customAlert
import com.example.collectionjanuary2020.builder.default_alert.Alert.Companion.alert
import com.example.collectionjanuary2020.builder.dialog_fragment.DialogDSLbuilder.Companion.dialog
import com.example.collectionjanuary2020.builder.permission.PermissionDSLBuilder.Companion.getPermissions
import kotlinx.android.synthetic.main.activity_main_dsl.*
import kotlinx.android.synthetic.main.layout_dialog.view.*

class MainActivityDSL : AppCompatActivity() {
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_dsl)
        context = this
        bt_permission.setOnClickListener {
            requestStoragePermission()
        }
        bt_default_dialog.setOnClickListener {
            showDefaultDialog(it)
        }
        bt_custom_alert_dialog.setOnClickListener {
            showCustomAlert(it)
        }
        bt_dialog_fragment.setOnClickListener {
            showDialogFragment(it)
        }
        bt_bottom_sheet.setOnClickListener {
            showBottomSheetDialog(it)
        }
    }

    private fun showCustomAlert(it: View) {
        val alertData = AlertData(
            "This is a Custom Dialog Title",
            "This is a Custom Dialog Description"
        )
        customAlert {
            layoutId = R.layout.layout_dialog
            setCustomView = { it: View, dialog: AlertDialog ->
                it.findViewById<TextView>(R.id.title).text = alertData.title
                it.findViewById<TextView>(R.id.description).text = alertData.description
                it.findViewById<TextView>(R.id.accept).setOnClickListener {
                    Toast.makeText(context, "accept button click", Toast.LENGTH_LONG).show()
                    dialog.dismiss()
                }
                it.findViewById<TextView>(R.id.reject).setOnClickListener {
                    Toast.makeText(context, "reject button click", Toast.LENGTH_LONG).show()
                    dialog.dismiss()
                }
            }
        }
    }

    fun requestStoragePermission() {
        val permissionsList = arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )

        getPermissions {
            permissions = permissionsList
            onPermissionGranted = {
                Toast.makeText(context, "Permission Given", Toast.LENGTH_LONG).show()
            }
            onPermissionDenied = {
                Toast.makeText(context, "Permission Denied", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun showDefaultDialog(view: View) {
        alert {
            title = "title dialog"
            description = "description"
            alertContext = context
            positiveButton = {
                Toast.makeText(context, "Yes", Toast.LENGTH_LONG).show()
            }
            negativeButton = {
                Toast.makeText(context, "And No", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun showDialogFragment(view: View) {
        dialog {
            layoutId = R.layout.layout_dialog
            setCustomView = { it: View, dialog: DialogFragment ->
                it.title.text = getString(R.string.fragment_dialog_title)
                it.description.text = getString(R.string.fragment_dialog_description)

                it.accept.setOnClickListener {
                    Toast.makeText(context, "accept button click", Toast.LENGTH_LONG).show()
                    dialog.dismiss()
                }

                it.reject.setOnClickListener {
                    Toast.makeText(context, "reject button click", Toast.LENGTH_LONG).show()
                    dialog.dismiss()
                }
            }
        }
    }

    fun showBottomSheetDialog(view: View) {
        bottomSheetDialog {
            layoutId = R.layout.layout_dialog
            setCustomView = { it: View, dialog: DialogFragment ->

                it.title.text = getString(R.string.fragment_dialog_title)
                it.description.text = getString(R.string.fragment_dialog_description)

                it.accept.setOnClickListener {
                    Toast.makeText(context, "accept button click", Toast.LENGTH_LONG).show()
                    dialog.dismiss()
                }

                it.reject.setOnClickListener {
                    Toast.makeText(context, "reject button click", Toast.LENGTH_LONG).show()
                    dialog.dismiss()
                }

            }
        }
    }
}