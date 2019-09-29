package views

import wrapper.div
import wrapper.vComponent
import wrapper.vRender

fun Home() = vComponent {
    setup { _, _ ->
        vRender {
            div {
                +"Welcome to Kotlin/Vue"
            }
        }
    }
}