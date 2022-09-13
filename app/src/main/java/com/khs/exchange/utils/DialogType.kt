package com.khs.exchange.utils

import androidx.annotation.StringRes

sealed class DialogType(
    @StringRes open val text: Int?,
    open val textStr: String?
) {
    class Success(
        @StringRes override val text: Int? = null,
        override val textStr: String? = null
    ) : DialogType(text, textStr)

    class Error(
        @StringRes override val text: Int? = null,
        override val textStr: String? = null
    ) : DialogType(text, textStr)

    class Warning(
        @StringRes override val text: Int? = null,
        override val textStr: String? = null
    ) : DialogType(text, textStr)

    class Info(
        @StringRes override val text: Int? = null,
        override val textStr: String? = null
    ) : DialogType(text, textStr)
}
