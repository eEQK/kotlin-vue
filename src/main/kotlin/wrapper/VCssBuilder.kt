package wrapper

import kotlinx.css.StyledElement
import kotlinx.css.TagSelector
import org.w3c.dom.Element
import org.w3c.dom.css.CSSStyleSheet
import wrapper.internal.utils.with
import kotlin.browser.document

internal typealias VCssRuleSet = VCssBuilder.() -> Unit

class VCssBuilder : StyledElement() {

    val rules = mutableListOf<VCssRule>()

    fun add(block: VCssBuilder.() -> Unit) = block()

    fun add(id: String, block: VCssBuilder.() -> Unit): VCssRule {
        rules.add(id with this(block))
        return rules.last()
    }

    operator fun invoke(block: VCssBuilder.() -> Unit): VCssBuilder = VCssBuilder().apply(block)

    operator fun VCssRuleSet.unaryPlus() = add(this)
    operator fun String.invoke(block: VCssRuleSet) = add(this, block)
    operator fun String.invoke(selector: String, block: VCssRuleSet) = add(this + selector, block)
    operator fun TagSelector.invoke(block: VCssRuleSet) = tagName(block)
    operator fun TagSelector.invoke(selector: String, block: VCssRuleSet) = "$tagName$selector"(block)

    override fun toString() =
        rules.joinToString(" ") { "$it" }
}

fun buildCss(css: VCssBuilder, name: String?) {

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
