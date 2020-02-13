package com.example.collectionjanuary2020.builder.dialog_fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.collectionjanuary2020.builder.TAG

class MyDialogFragment : DialogFragment() {
    var layoutId: Int? = null

    lateinit var callback: (View, DialogFragment) -> Unit

    companion object {

        val TAG = MyDialogFragment::TAG.toString()

        fun newInstance(layoutId: Int?): MyDialogFragment {
            return MyDialogFragment().apply {
                arguments = Bundle().apply {
                    putInt("layoutId", layoutId!!)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        layoutId = arguments?.getInt("layoutId")
        if (layoutId == null) throw Exception("layoutId can't be null")
        return inflater.inflate(layoutId!!, container, false)
    }

    fun setCustomView(customview: (View, DialogFragment) -> Unit) {
        callback = customview
    }

    override fun onStart() {
        super.onStart()
        val deviceWidth = context!!.resources.displayMetrics.widthPixels
        dialog?.window?.setLayout(deviceWidth, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callback.invoke(view, this)
    }
}