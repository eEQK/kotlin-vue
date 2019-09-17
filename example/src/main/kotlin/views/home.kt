package views

import wrapper.div
import wrapper.i
import wrapper.vComponent
import wrapper.vRender

fun home() = vComponent<Unit> {
    setup = { _, _ ->
        vRender {
            div {

                +"Hello Kotlin/Vue! "
                i { `class` = "far fa-smile" }

            }
        }
    }
}


