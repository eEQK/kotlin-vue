package wrapper

import kotlinx.css.StyledElement
import kotlinx.css.hyphenize
import wrapper.internal.VCssDsl

typealias VCssRulesBlock = VCssRule.() -> Unit

@VCssDsl
class VCssRule : StyledElement() {

    private lateinit var block: VCssRulesBlock
    private var selector: String? = null

    override fun toString() = buildDeclarations(block)
        .let {
            if (selector == null) it
            else "$selector { $it }".prependIndent()
        }

    operator fun invoke(block: VCssRulesBlock) =
        VCssRule().apply(block)

    fun buildDeclarations(block: VCssRulesBlock) =
        invoke(block).declarations
            .map { "${it.key.hyphenize()}: ${it.value};" }
            .joinToString("")

    companion object {
        fun of(
            block: VCssRule.() -> Unit,
            selector: String? = null
        ) = VCssRule()
            .apply {
                this.block = block
                this.selector = selector
            }
    }
}