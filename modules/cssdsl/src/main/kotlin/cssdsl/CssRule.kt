package cssdsl

import cssdsl.internal.CssDsl
import kotlinx.css.StyledElement
import kotlinx.css.hyphenize

typealias CssRulesBlock = CssRule.() -> Unit

@CssDsl
class CssRule : StyledElement() {

    private lateinit var block: CssRulesBlock
    private var selector: String? = null

    override fun toString() = buildDeclarations(block)
        .let {
            if (selector == null) it
            else "$selector {\n$it\n}".prependIndent()
        }

    operator fun invoke(block: CssRulesBlock) =
        CssRule().apply(block)

    fun buildDeclarations(block: CssRulesBlock) =
        invoke(block).declarations
            .map { "${it.key.hyphenize()}: ${it.value};" }
            .joinToString("\n")

    companion object {
        fun of(
            block: CssRule.() -> Unit,
            selector: String? = null
        ) = CssRule()
            .apply {
                this.block = block
                this.selector = selector
            }
    }
}