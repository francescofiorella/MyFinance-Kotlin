package com.frafio.myfinance.utils

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.frafio.myfinance.R
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

fun View.snackbar(message: String, anchor: View? = null) {
    val nunito = ResourcesCompat.getFont(context, R.font.nunito)

    val snackbar = Snackbar.make(this, message, BaseTransientBottomBar.LENGTH_SHORT)
        .setBackgroundTint(ContextCompat.getColor(context, R.color.snackbar_bg))
        .setTextColor(ContextCompat.getColor(context, R.color.inverted_primary_text))

    anchor?.let{
        snackbar.setAnchorView(it)
    }

    val tv = snackbar.view.findViewById<TextView>(R.id.snackbar_text)
    tv.typeface = nunito

    snackbar.show()
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}