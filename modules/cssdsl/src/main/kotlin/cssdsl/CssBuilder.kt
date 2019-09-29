package cssdsl

import cssdsl.internal.CssDsl
import kotlinx.css.TagSelector

typealias CssRuleSet = CssBuilder.() -> Unit

@CssDsl
class CssBuilder {

    val rules = mutableListOf<CssRule>()

    operator fun invoke(block: CssRuleSet): CssBuilder =
        of(block)

    fun import(id: String, block: CssRulesBlock) {
        rules.add(CssRule.of(block, id))
    }

    operator fun String.invoke(block: CssRulesBlock) = import(this, block)
    operator fun String.invoke(selector: String, block: CssRulesBlock) = import(this + selector, block)
    operator fun TagSelector.invoke(block: CssRulesBlock) = tagName(block)
    operator fun TagSelector.invoke(selector: String, block: CssRulesBlock) = "$tagName$selector"(block)

    fun import(block: CssRuleSet) = this.block()
    operator fun (CssRuleSet).unaryPlus() = import(this)

    override fun toString() =
        rules.joinToString(" ") { "$it" }

    companion object {
        fun of(block: CssRuleSet) = CssBuilder().apply(block)
    }
}