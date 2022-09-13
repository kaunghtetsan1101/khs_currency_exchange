package com.khs.exchange.utils

import android.os.SystemClock
import android.view.View

inline fun View.setOnClickDebounceListener(
    debounceTime: Long = 600L,
    crossinline action: View.() -> Unit
) {
    setOnClickListener(object : View.OnClickListener {
        private var lastClickTime: Long = 0
        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - lastClickTime < debounceTime) return
            else v.action()
            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}