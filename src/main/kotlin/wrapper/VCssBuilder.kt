package wrapper

import kotlinx.css.TagSelector
import org.w3c.dom.Element
import org.w3c.dom.css.CSSStyleSheet
import wrapper.internal.VCssDsl
import kotlin.browser.document

typealias VCssRuleSet = VCssBuilder.() -> Unit

@VCssDsl
class VCssBuilder {

    val rules = mutableListOf<VCssRule>()

    operator fun invoke(block: VCssBuilder.() -> Unit): VCssBuilder =
        VCssBuilder().apply(block).also { println(rules) }

    fun import(id: String, block: VCssRulesBlock) {
        rules.add(VCssRule.of(block, id))
    }

    operator fun String.invoke(block: VCssRule.() -> Unit) = import(this, block)
    operator fun String.invoke(selector: String, block: VCssRule.() -> Unit) = import(this + selector, block)
    operator fun TagSelector.invoke(block: VCssRule.() -> Unit) = tagName(block)
    operator fun TagSelector.invoke(selector: String, block: VCssRule.() -> Unit) = "$tagName$selector"(block)

    fun import(block: VCssBuilder.() -> Unit) = block()
    operator fun (VCssBuilder.() -> Unit).unaryPlus() = import(this)

    override fun toString() =
        rules.joinToString(" ") { "$it" }
}

internal fun buildCss(css: VCssBuilder, name: String?) {

    if (name == null) {
        return
    }

    document.getElementById(name)?.let { return }

    val style: Element = document.createElement("style")

    style.id = name

    style.setAttribute("type", "text/css")

    document.head?.appendChild(style)

    val sheet = style.asDynamic().sheet.unsafeCast<CSSStyleSheet>()

    css.rules.withIndex().map {
        sheet.insertRule(it.value.toString(), it.index)
    }
}
