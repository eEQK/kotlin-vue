package wrapper.internal.utils

import wrapper.VCssBuilder
import wrapper.VCssRule

internal fun String?.nullIfBlank() =
    if (isNullOrBlank()) null
    else this!!

infix fun String.with(that: VCssBuilder) = VCssRule(this, that)