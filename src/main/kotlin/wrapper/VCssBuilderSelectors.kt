@file:Suppress("unused")

package wrapper

import kotlinx.css.content
import kotlinx.css.quoted

fun VCssBuilder.universal(block: VCssRulesBlock) = "*"(block)
fun VCssBuilder.media(query: String, block: VCssRulesBlock) = "@media $query"(block)
fun VCssBuilder.supports(query: String, block: VCssRulesBlock) = "@supports $query"(block)
fun VCssBuilder.fontFace(query: String, block: VCssRulesBlock) = "@font-face $query"(block)

fun VCssBuilder.active(selector: String = "") = "$selector:active"
fun VCssBuilder.active(selector: String = "", block: VCssRulesBlock) = "$selector:active"(block)
fun VCssBuilder.checked(selector: String = "") = "$selector:checked"
fun VCssBuilder.checked(selector: String = "", block: VCssRulesBlock) = "$selector:checked"(block)
fun VCssBuilder.default(selector: String = "") = "$selector:default"
fun VCssBuilder.default(selector: String = "", block: VCssRulesBlock) = "$selector:default"(block)
fun VCssBuilder.disabled(selector: String = "") = "$selector:disabled"
fun VCssBuilder.disabled(selector: String = "", block: VCssRulesBlock) = "$selector:disabled"(block)
fun VCssBuilder.empty(selector: String = "") = "$selector:empty"
fun VCssBuilder.empty(selector: String = "", block: VCssRulesBlock) = "$selector:empty"(block)
fun VCssBuilder.firstChild(selector: String = "") = "$selector:first-child"
fun VCssBuilder.firstChild(selector: String = "", block: VCssRulesBlock) = "$selector:first-child"(block)
fun VCssBuilder.firstOfType(selector: String = "") = "$selector:first-of-type"
fun VCssBuilder.firstOfType(selector: String = "", block: VCssRulesBlock) = "$selector:first-of-type"(block)
fun VCssBuilder.focus(selector: String = "") = "$selector:focus"
fun VCssBuilder.focus(selector: String = "", block: VCssRulesBlock) = "$selector:focus"(block)
fun VCssBuilder.hover(selector: String = "") = "$selector:hover"
fun VCssBuilder.hover(selector: String = "", block: VCssRulesBlock) = "$selector:hover"(block)
fun VCssBuilder.indeterminate(selector: String = "") = "$selector:indeterminate"
fun VCssBuilder.indeterminate(selector: String = "", block: VCssRulesBlock) = "$selector:indeterminate"(block)
fun VCssBuilder.inRange(selector: String = "") = "$selector:in-range"
fun VCssBuilder.inRange(selector: String = "", block: VCssRulesBlock) = "$selector:in-range"(block)
fun VCssBuilder.invalid(selector: String = "") = "$selector:invalid"
fun VCssBuilder.invalid(selector: String = "", block: VCssRulesBlock) = "$selector:invalid"(block)
fun VCssBuilder.lastChild(selector: String = "") = "$selector:last-child"
fun VCssBuilder.lastChild(selector: String = "", block: VCssRulesBlock) = "$selector:last-child"(block)
fun VCssBuilder.link(selector: String = "") = "$selector:link"
fun VCssBuilder.link(selector: String = "", block: VCssRulesBlock) = "$selector:link"(block)
fun VCssBuilder.onlyChild(selector: String = "") = "$selector:only-child"
fun VCssBuilder.onlyChild(selector: String = "", block: VCssRulesBlock) = "$selector:only-child"(block)
fun VCssBuilder.onlyOfType(selector: String = "") = "$selector:only-of-type"
fun VCssBuilder.onlyOfType(selector: String = "", block: VCssRulesBlock) = "$selector:only-of-type"(block)
fun VCssBuilder.optional(selector: String = "") = "$selector:optional"
fun VCssBuilder.optional(selector: String = "", block: VCssRulesBlock) = "$selector:optional"(block)
fun VCssBuilder.outOfRange(selector: String = "") = "$selector:out-of-range"
fun VCssBuilder.outOfRange(selector: String = "", block: VCssRulesBlock) = "$selector:out-of-range"(block)
fun VCssBuilder.readOnly(selector: String = "") = "$selector:read-only"
fun VCssBuilder.readOnly(selector: String = "", block: VCssRulesBlock) = "$selector:read-only"(block)
fun VCssBuilder.readWrite(selector: String = "") = "$selector:read-write"
fun VCssBuilder.readWrite(selector: String = "", block: VCssRulesBlock) = "$selector:read-write"(block)
fun VCssBuilder.required(selector: String = "") = "$selector:required"
fun VCssBuilder.required(selector: String = "", block: VCssRulesBlock) = "$selector:required"(block)
fun VCssBuilder.valid(selector: String = "") = "$selector:valid"
fun VCssBuilder.valid(selector: String = "", block: VCssRulesBlock) = "$selector:valid"(block)
fun VCssBuilder.visited(selector: String = "") = "$selector:visited"
fun VCssBuilder.visited(selector: String = "", block: VCssRulesBlock) = "$selector:visited"(block)
fun VCssBuilder.nthOfType(selector: String = "") = ":nth-of-type($selector)"
fun VCssBuilder.nthOfType(selector: String = "", block: VCssRulesBlock) = ":nth-of-type($selector)"(block)
fun VCssBuilder.nthChild(selector: String = "") = "nth-child($selector)"
fun VCssBuilder.nthChild(selector: String = "", block: VCssRulesBlock) = "nth-child($selector)"(block)
fun VCssBuilder.nthLastChild(selector: String = "") = "nth-last-child($selector)"
fun VCssBuilder.nthLastChild(selector: String = "", block: VCssRulesBlock) = "nth-last-child($selector)"(block)
fun VCssBuilder.nthLastOfType(selector: String = "") = "nth-last-of-type($selector)"
fun VCssBuilder.nthLastOfType(selector: String = "", block: VCssRulesBlock) = "nth-last-of-type($selector)"(block)
fun VCssBuilder.not(selector: String) = ":not($selector)"
fun VCssBuilder.not(selector: String, block: VCssRulesBlock) = ":not($selector)"(block)
fun VCssBuilder.children(selector: String? = null) = " > ${selector?.let { it } ?: "*"}"
fun VCssBuilder.children(selector: String? = null, block: VCssRulesBlock) = " > ${selector?.let { it } ?: "*"}"(block)
fun VCssBuilder.descendants(selector: String? = null) = " ${selector?.let { it } ?: "*"}"
fun VCssBuilder.descendants(selector: String? = null, block: VCssRulesBlock) = " ${selector?.let { it } ?: "*"}"(block)
fun VCssBuilder.child(selector: String) = "> $selector"
fun VCssBuilder.child(selector: String, block: VCssRulesBlock) = "> $selector"(block)
fun VCssBuilder.sibling(selector: String) = "~ $selector"
fun VCssBuilder.sibling(selector: String, block: VCssRulesBlock) = "~ $selector"(block)
fun VCssBuilder.adjacentSibling(selector: String) = "+ $selector"
fun VCssBuilder.adjacentSibling(selector: String, block: VCssRulesBlock) = "+ $selector"(block)

fun VCssBuilder.placeholder() = "::placeholder"
fun VCssBuilder.placeholder(block: VCssRulesBlock) = "::placeholder"(block)
fun VCssBuilder.after() = "::after"
fun VCssBuilder.after(block: VCssRulesBlock) = "::after" {
    content = "".quoted
    block()
}

fun VCssBuilder.before() = "::before"
fun VCssBuilder.before(block: VCssRulesBlock) = "::before" {
    content = "".quoted
    block()
}