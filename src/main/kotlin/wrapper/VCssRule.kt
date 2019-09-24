package wrapper

import kotlinx.css.hyphenize

class VCssRule(private val id: String, private val inner: VCssBuilder) {
    override fun toString() =
        inner.declarations
            .map { "${it.key.hyphenize()}: ${it.value};" }
            .joinToString("")
            .let { "$id { $it $inner }" }
}