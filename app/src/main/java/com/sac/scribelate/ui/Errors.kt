package com.sac.scribelate.ui

import android.content.Context
import com.sac.scribelate.R
import com.sac.scribelate.data.TranscribeException

/** The sentence shown to the person for a failed transcription. */
fun TranscribeException.userMessage(context: Context): String = when (kind) {
    TranscribeException.Kind.MISSING_KEY -> context.getString(R.string.error_no_key)
    TranscribeException.Kind.BAD_KEY -> context.getString(R.string.error_bad_key)
    TranscribeException.Kind.NO_AUDIO -> context.getString(R.string.error_no_audio)
    TranscribeException.Kind.NO_SPEECH -> context.getString(R.string.error_no_speech)
    TranscribeException.Kind.NETWORK -> context.getString(R.string.error_network)
    TranscribeException.Kind.UNREADABLE -> context.getString(R.string.error_read)
    TranscribeException.Kind.API,
    TranscribeException.Kind.UNKNOWN ->
        message?.takeIf { it.isNotBlank() } ?: context.getString(R.string.error_generic)
}
