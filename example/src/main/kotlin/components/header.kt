package components

import kotlinx.css.*
import wrapper.div
import wrapper.vComponent
import wrapper.vRender

fun primaryHeader() = vComponent<Unit> {
    setup = { _, _ ->
        vRender {
            div {
                `class` = "navbar mb-5"

                style {
                    color = Color.inherit
                    fontSize = LinearDimension("x-large")
                    fontWeight = FontWeight.bold
                    display = Display.flex
                    alignItems = Align.center
                }

                +"Kotlin/Vue"
            }
        }
    }
}

