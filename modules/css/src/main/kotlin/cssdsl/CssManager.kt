package cssdsl

import org.w3c.dom.Element
import org.w3c.dom.css.CSSStyleSheet
import kotlin.browser.document

private val globalStyle: Lazy<Element> = lazy {
    document.createElement("style")
        .apply {
            id = "global"
            setAttribute("type", "text/css")
        }.let { document.head?.appendChild(it) } as Element
}

class CssManager {

    companion object {

        fun append(css: CssBuilder, selector: String?, scoped: Boolean = false) =
            when (scoped) {
                true -> handleScopedCss(css, selector)
                false -> handleGlobalCss(css)
            }

        fun handleGlobalCss(css: CssBuilder) {
            appendCssToStyle(globalStyle.value, css)
        }

        fun handleScopedCss(css: CssBuilder, selector: String?) {

        }

        fun appendCssToStyle(element: Element, css: CssBuilder) {
            element.asDynamic()
                .sheet
                .unsafeCast<CSSStyleSheet>()
                .let { sheet ->
                    css.rules.withIndex().map {
                        sheet.insertRule(it.value.toString(), it.index)
                    }
                }

            element.innerHTML += "$css\n"
        }
    }
}