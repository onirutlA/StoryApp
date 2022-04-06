package com.onirutla.storyapp.custom_component

import android.content.Context
import android.graphics.Canvas
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class CustomPasswordEditText : AppCompatEditText {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defAttrs: Int) : super(
        context,
        attrs,
        defAttrs
    ) {
        init()
    }

    private fun init() {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(s: CharSequence, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(e: Editable) {
                if (e.length < 6) error = "Minimal 6 karakter"
            }

        })

    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}