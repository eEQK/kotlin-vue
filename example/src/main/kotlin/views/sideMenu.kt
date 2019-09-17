package views

import external.vue.VNode
import wrapper.*

fun sideMenu() = vComponent<Unit> {
    setup = { _, _ ->
        vRender {
            div {

                `class` = "d-flex flex-column ml-4 mr-4"

                btn("Home", "")
                btn("Binding", "binding")
                btn("Binding 2", "binding2")
                btn("Directives", "directives")

            }
        }
    }
}

fun VRender<*, *, *>.btn(text: String, route: String): VNode =
    a {
        domProps {
            href = "#/$route"
        }

        `class` = "btn btn-outline-dark"
        +text
    }