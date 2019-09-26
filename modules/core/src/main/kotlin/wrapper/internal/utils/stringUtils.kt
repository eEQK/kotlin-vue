package wrapper.internal.utils

internal fun String?.nullIfBlank() =
    if (isNullOrBlank()) null
    else this!!