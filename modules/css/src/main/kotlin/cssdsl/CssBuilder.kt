package cssdsl

import cssdsl.internal.CssDsl
import kotlinx.css.TagSelector

typealias CssRuleSet = CssBuilder.() -> Unit

@CssDsl
class CssBuilder {

    val rules = mutableListOf<CssRule>()

    operator fun invoke(block: CssBuilder.() -> Unit): CssBuilder =
        CssBuilder().apply(block).also { println(rules) }

    fun import(id: String, block: CssRulesBlock) {
        rules.add(CssRule.of(block, id))
    }

    operator fun String.invoke(block: CssRule.() -> Unit) = import(this, block)
    operator fun String.invoke(selector: String, block: CssRule.() -> Unit) = import(this + selector, block)
    operator fun TagSelector.invoke(block: CssRule.() -> Unit) = tagName(block)
    operator fun TagSelector.invoke(selector: String, block: CssRule.() -> Unit) = "$tagName$selector"(block)

    fun import(block: CssBuilder.() -> Unit) = block()
    operator fun (CssBuilder.() -> Unit).unaryPlus() = import(this)

    override fun toString() =
        rules.joinToString(" ") { "$it" }
}