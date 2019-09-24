@file:Suppress("unused")

package wrapper

import kotlinx.css.content
import kotlinx.css.quoted

fun VCssBuilder.universal(block: VCssRuleSet) = "*"(block)
fun VCssBuilder.media(query: String, block: VCssRuleSet) = "@media $query"(block)
fun VCssBuilder.supports(query: String, block: VCssRuleSet) = "@supports $query"(block)
fun VCssBuilder.fontFace(query: String, block: VCssRuleSet) = "@font-face $query"(block)

fun VCssBuilder.active(selector: String = "") = "$selector:active"
fun VCssBuilder.active(selector: String = "", block: VCssRuleSet) = "$selector:active"(block)
fun VCssBuilder.checked(selector: String = "") = "$selector:checked"
fun VCssBuilder.checked(selector: String = "", block: VCssRuleSet) = "$selector:checked"(block)
fun VCssBuilder.default(selector: String = "") = "$selector:default"
fun VCssBuilder.default(selector: String = "", block: VCssRuleSet) = "$selector:default"(block)
fun VCssBuilder.disabled(selector: String = "") = "$selector:disabled"
fun VCssBuilder.disabled(selector: String = "", block: VCssRuleSet) = "$selector:disabled"(block)
fun VCssBuilder.empty(selector: String = "") = "$selector:empty"
fun VCssBuilder.empty(selector: String = "", block: VCssRuleSet) = "$selector:empty"(block)
fun VCssBuilder.firstChild(selector: String = "") = "$selector:first-child"
fun VCssBuilder.firstChild(selector: String = "", block: VCssRuleSet) = "$selector:first-child"(block)
fun VCssBuilder.firstOfType(selector: String = "") = "$selector:first-of-type"
fun VCssBuilder.firstOfType(selector: String = "", block: VCssRuleSet) = "$selector:first-of-type"(block)
fun VCssBuilder.focus(selector: String = "") = "$selector:focus"
fun VCssBuilder.focus(selector: String = "", block: VCssRuleSet) = "$selector:focus"(block)
fun VCssBuilder.hover(selector: String = "") = "$selector:hover"
fun VCssBuilder.hover(selector: String = "", block: VCssRuleSet) = "$selector:hover"(block)
fun VCssBuilder.indeterminate(selector: String = "") = "$selector:indeterminate"
fun VCssBuilder.indeterminate(selector: String = "", block: VCssRuleSet) = "$selector:indeterminate"(block)
fun VCssBuilder.inRange(selector: String = "") = "$selector:in-range"
fun VCssBuilder.inRange(selector: String = "", block: VCssRuleSet) = "$selector:in-range"(block)
fun VCssBuilder.invalid(selector: String = "") = "$selector:invalid"
fun VCssBuilder.invalid(selector: String = "", block: VCssRuleSet) = "$selector:invalid"(block)
fun VCssBuilder.lastChild(selector: String = "") = "$selector:last-child"
fun VCssBuilder.lastChild(selector: String = "", block: VCssRuleSet) = "$selector:last-child"(block)
fun VCssBuilder.link(selector: String = "") = "$selector:link"
fun VCssBuilder.link(selector: String = "", block: VCssRuleSet) = "$selector:link"(block)
fun VCssBuilder.onlyChild(selector: String = "") = "$selector:only-child"
fun VCssBuilder.onlyChild(selector: String = "", block: VCssRuleSet) = "$selector:only-child"(block)
fun VCssBuilder.onlyOfType(selector: String = "") = "$selector:only-of-type"
fun VCssBuilder.onlyOfType(selector: String = "", block: VCssRuleSet) = "$selector:only-of-type"(block)
fun VCssBuilder.optional(selector: String = "") = "$selector:optional"
fun VCssBuilder.optional(selector: String = "", block: VCssRuleSet) = "$selector:optional"(block)
fun VCssBuilder.outOfRange(selector: String = "") = "$selector:out-of-range"
fun VCssBuilder.outOfRange(selector: String = "", block: VCssRuleSet) = "$selector:out-of-range"(block)
fun VCssBuilder.readOnly(selector: String = "") = "$selector:read-only"
fun VCssBuilder.readOnly(selector: String = "", block: VCssRuleSet) = "$selector:read-only"(block)
fun VCssBuilder.readWrite(selector: String = "") = "$selector:read-write"
fun VCssBuilder.readWrite(selector: String = "", block: VCssRuleSet) = "$selector:read-write"(block)
fun VCssBuilder.required(selector: String = "") = "$selector:required"
fun VCssBuilder.required(selector: String = "", block: VCssRuleSet) = "$selector:required"(block)
fun VCssBuilder.valid(selector: String = "") = "$selector:valid"
fun VCssBuilder.valid(selector: String = "", block: VCssRuleSet) = "$selector:valid"(block)
fun VCssBuilder.visited(selector: String = "") = "$selector:visited"
fun VCssBuilder.visited(selector: String = "", block: VCssRuleSet) = "$selector:visited"(block)
fun VCssBuilder.nthOfType(selector: String = "") = ":nth-of-type($selector)"
fun VCssBuilder.nthOfType(selector: String = "", block: VCssRuleSet) = ":nth-of-type($selector)"(block)
fun VCssBuilder.nthChild(selector: String = "") = "nth-child($selector)"
fun VCssBuilder.nthChild(selector: String = "", block: VCssRuleSet) = "nth-child($selector)"(block)
fun VCssBuilder.nthLastChild(selector: String = "") = "nth-last-child($selector)"
fun VCssBuilder.nthLastChild(selector: String = "", block: VCssRuleSet) = "nth-last-child($selector)"(block)
fun VCssBuilder.nthLastOfType(selector: String = "") = "nth-last-of-type($selector)"
fun VCssBuilder.nthLastOfType(selector: String = "", block: VCssRuleSet) = "nth-last-of-type($selector)"(block)
fun VCssBuilder.not(selector: String) = ":not($selector)"
fun VCssBuilder.not(selector: String, block: VCssRuleSet) = ":not($selector)"(block)
fun VCssBuilder.children(selector: String? = null) = " > ${selector?.let { it } ?: "*"}"
fun VCssBuilder.children(selector: String? = null, block: VCssRuleSet) = " > ${selector?.let { it } ?: "*"}"(block)
fun VCssBuilder.descendants(selector: String? = null) = " ${selector?.let { it } ?: "*"}"
fun VCssBuilder.descendants(selector: String? = null, block: VCssRuleSet) = " ${selector?.let { it } ?: "*"}"(block)
fun VCssBuilder.child(selector: String) = "> $selector"
fun VCssBuilder.child(selector: String, block: VCssRuleSet) = "> $selector"(block)
fun VCssBuilder.sibling(selector: String) = "~ $selector"
fun VCssBuilder.sibling(selector: String, block: VCssRuleSet) = "~ $selector"(block)
fun VCssBuilder.adjacentSibling(selector: String) = "+ $selector"
fun VCssBuilder.adjacentSibling(selector: String, block: VCssRuleSet) = "+ $selector"(block)

fun VCssBuilder.placeholder() = "::placeholder"
fun VCssBuilder.placeholder(block: VCssRuleSet) = "::placeholder"(block)
fun VCssBuilder.after() = "::after"
fun VCssBuilder.after(block: VCssRuleSet) = "::after" {
    content = "".quoted
    block()
}

fun VCssBuilder.before() = "::before"
fun VCssBuilder.before(block: VCssRuleSet) = "::before" {
    content = "".quoted
    block()
}