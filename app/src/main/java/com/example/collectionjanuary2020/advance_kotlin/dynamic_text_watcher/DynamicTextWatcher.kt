package com.example.collectionjanuary2020.advance_kotlin.dynamic_text_watcher

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DynamicTextWatcher(
    private val afterChanged: ((Editable?) -> Unit) = {},
    private val beforeChanged: ((CharSequence?, Int, Int, Int) -> Unit) = { _, _, _, _ -> },
    private val onChanged: ((CharSequence?, Int, Int, Int) -> Unit) = { _, _, _, _ -> }
) : TextWatcher {
    override fun afterTextChanged(s: Editable?) {
        afterChanged(s)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        beforeChanged(s, start, count, after)
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        onChanged(s, start, before, count)
    }
}

class Test : AppCompatActivity() {
    private val test = TextView(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        test.addTextChangedListener(DynamicTextWatcher(
            onChanged = { string, _, _, _ -> updateNormal(string.toString()) }
        ))
    }

    fun updateNormal(content: String) {

    }

}