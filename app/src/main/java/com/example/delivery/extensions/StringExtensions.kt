package com.example.delivery.extensions

import android.icu.text.DecimalFormat
import java.math.BigDecimal

fun String.formatPrice(): String? = try {
    DecimalFormat("#.##").format(BigDecimal(this))
} catch (e: IllegalArgumentException) {
    takeIf { isBlank() }?.run { "" }
}