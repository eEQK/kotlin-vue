package directives

import org.w3c.dom.Node
import org.w3c.dom.events.Event
import wrapper.vDirective
import kotlin.browser.document

val outsideOfNodeClick = vDirective {
    var handleCustomClick: ((event: Event) -> Unit)? = null

    bind { el, binding, _, _ ->

        handleCustomClick = {
            val target = it.target
            if (target is Node && !(el.isSameNode(target) || el.contains(target))) {

                val expression = binding.expression

                if (expression is Function0<*>) {
                    expression()
                } else {
                    throw Error("The binding expression must be a callback with no parameters.")
                }
            }
        }

        el.addEventListener("click", { it.stopPropagation() })
        document.body?.addEventListener("click", handleCustomClick)
    }

    unbind { el, _, _, _ ->
        el.removeEventListener("click", { it.stopPropagation() })
        document.body?.removeEventListener("click", handleCustomClick)
    }
}
