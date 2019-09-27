@file:Suppress("unused")

package cssdsl

import kotlinx.css.content
import kotlinx.css.quoted

fun CssBuilder.universal(block: CssRulesBlock) = "*"(block)
fun CssBuilder.media(query: String, block: CssRulesBlock) = "@media $query"(block)
fun CssBuilder.supports(query: String, block: CssRulesBlock) = "@supports $query"(block)
fun CssBuilder.fontFace(query: String, block: CssRulesBlock) = "@font-face $query"(block)

fun CssBuilder.active(selector: String = "") = "$selector:active"
fun CssBuilder.active(selector: String = "", block: CssRulesBlock) = "$selector:active"(block)
fun CssBuilder.checked(selector: String = "") = "$selector:checked"
fun CssBuilder.checked(selector: String = "", block: CssRulesBlock) = "$selector:checked"(block)
fun CssBuilder.default(selector: String = "") = "$selector:default"
fun CssBuilder.default(selector: String = "", block: CssRulesBlock) = "$selector:default"(block)
fun CssBuilder.disabled(selector: String = "") = "$selector:disabled"
fun CssBuilder.disabled(selector: String = "", block: CssRulesBlock) = "$selector:disabled"(block)
fun CssBuilder.empty(selector: String = "") = "$selector:empty"
fun CssBuilder.empty(selector: String = "", block: CssRulesBlock) = "$selector:empty"(block)
fun CssBuilder.firstChild(selector: String = "") = "$selector:first-child"
fun CssBuilder.firstChild(selector: String = "", block: CssRulesBlock) = "$selector:first-child"(block)
fun CssBuilder.firstOfType(selector: String = "") = "$selector:first-of-type"
fun CssBuilder.firstOfType(selector: String = "", block: CssRulesBlock) = "$selector:first-of-type"(block)
fun CssBuilder.focus(selector: String = "") = "$selector:focus"
fun CssBuilder.focus(selector: String = "", block: CssRulesBlock) = "$selector:focus"(block)
fun CssBuilder.hover(selector: String = "") = "$selector:hover"
fun CssBuilder.hover(selector: String = "", block: CssRulesBlock) = "$selector:hover"(block)
fun CssBuilder.indeterminate(selector: String = "") = "$selector:indeterminate"
fun CssBuilder.indeterminate(selector: String = "", block: CssRulesBlock) = "$selector:indeterminate"(block)
fun CssBuilder.inRange(selector: String = "") = "$selector:in-range"
fun CssBuilder.inRange(selector: String = "", block: CssRulesBlock) = "$selector:in-range"(block)
fun CssBuilder.invalid(selector: String = "") = "$selector:invalid"
fun CssBuilder.invalid(selector: String = "", block: CssRulesBlock) = "$selector:invalid"(block)
fun CssBuilder.lastChild(selector: String = "") = "$selector:last-child"
fun CssBuilder.lastChild(selector: String = "", block: CssRulesBlock) = "$selector:last-child"(block)
fun CssBuilder.link(selector: String = "") = "$selector:link"
fun CssBuilder.link(selector: String = "", block: CssRulesBlock) = "$selector:link"(block)
fun CssBuilder.onlyChild(selector: String = "") = "$selector:only-child"
fun CssBuilder.onlyChild(selector: String = "", block: CssRulesBlock) = "$selector:only-child"(block)
fun CssBuilder.onlyOfType(selector: String = "") = "$selector:only-of-type"
fun CssBuilder.onlyOfType(selector: String = "", block: CssRulesBlock) = "$selector:only-of-type"(block)
fun CssBuilder.optional(selector: String = "") = "$selector:optional"
fun CssBuilder.optional(selector: String = "", block: CssRulesBlock) = "$selector:optional"(block)
fun CssBuilder.outOfRange(selector: String = "") = "$selector:out-of-range"
fun CssBuilder.outOfRange(selector: String = "", block: CssRulesBlock) = "$selector:out-of-range"(block)
fun CssBuilder.readOnly(selector: String = "") = "$selector:read-only"
fun CssBuilder.readOnly(selector: String = "", block: CssRulesBlock) = "$selector:read-only"(block)
fun CssBuilder.readWrite(selector: String = "") = "$selector:read-write"
fun CssBuilder.readWrite(selector: String = "", block: CssRulesBlock) = "$selector:read-write"(block)
fun CssBuilder.required(selector: String = "") = "$selector:required"
fun CssBuilder.required(selector: String = "", block: CssRulesBlock) = "$selector:required"(block)
fun CssBuilder.valid(selector: String = "") = "$selector:valid"
fun CssBuilder.valid(selector: String = "", block: CssRulesBlock) = "$selector:valid"(block)
fun CssBuilder.visited(selector: String = "") = "$selector:visited"
fun CssBuilder.visited(selector: String = "", block: CssRulesBlock) = "$selector:visited"(block)
fun CssBuilder.nthOfType(selector: String = "") = ":nth-of-type($selector)"
fun CssBuilder.nthOfType(selector: String = "", block: CssRulesBlock) = ":nth-of-type($selector)"(block)
fun CssBuilder.nthChild(selector: String = "") = "nth-child($selector)"
fun CssBuilder.nthChild(selector: String = "", block: CssRulesBlock) = "nth-child($selector)"(block)
fun CssBuilder.nthLastChild(selector: String = "") = "nth-last-child($selector)"
fun CssBuilder.nthLastChild(selector: String = "", block: CssRulesBlock) = "nth-last-child($selector)"(block)
fun CssBuilder.nthLastOfType(selector: String = "") = "nth-last-of-type($selector)"
fun CssBuilder.nthLastOfType(selector: String = "", block: CssRulesBlock) = "nth-last-of-type($selector)"(block)
fun CssBuilder.not(selector: String) = ":not($selector)"
fun CssBuilder.not(selector: String, block: CssRulesBlock) = ":not($selector)"(block)
fun CssBuilder.children(selector: String? = null) = " > ${selector?.let { it } ?: "*"}"
fun CssBuilder.children(selector: String? = null, block: CssRulesBlock) = " > ${selector?.let { it } ?: "*"}"(block)
fun CssBuilder.descendants(selector: String? = null) = " ${selector?.let { it } ?: "*"}"
fun CssBuilder.descendants(selector: String? = null, block: CssRulesBlock) = " ${selector?.let { it } ?: "*"}"(block)
fun CssBuilder.child(selector: String) = "> $selector"
fun CssBuilder.child(selector: String, block: CssRulesBlock) = "> $selector"(block)
fun CssBuilder.sibling(selector: String) = "~ $selector"
fun CssBuilder.sibling(selector: String, block: CssRulesBlock) = "~ $selector"(block)
fun CssBuilder.adjacentSibling(selector: String) = "+ $selector"
fun CssBuilder.adjacentSibling(selector: String, block: CssRulesBlock) = "+ $selector"(block)
fun CssBuilder.placeholder() = "::placeholder"
fun CssBuilder.placeholder(block: CssRulesBlock) = "::placeholder"(block)
fun CssBuilder.after() = "::after"
fun CssBuilder.after(block: CssRulesBlock) = "::after" {
    content = "".quoted
    block()
}

fun CssBuilder.before() = "::before"
fun CssBuilder.before(block: CssRulesBlock) = "::before" {
    content = "".quoted
    block()
}