package views

import kotlinx.css.Color
import kotlinx.css.color
import kotlinx.css.i
import wrapper.div
import wrapper.i
import wrapper.vComponent
import wrapper.vRender

fun home() = vComponent<Unit> {
    css {
        i {
            color = Color.red
        }
    }
    setup = { _, _ ->
        vRender {
            div {

                +"Hello Kotlin/Vue! "
                i { `class` = "far fa-smile" }

            }
        }
    }
}


