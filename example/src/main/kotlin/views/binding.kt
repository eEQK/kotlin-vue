package components

import external.composition_api.ref
import kotlinx.css.LinearDimension
import kotlinx.css.height
import kotlinx.css.width
import wrapper.div
import wrapper.span
import wrapper.vComponent
import wrapper.vRender

fun binding() = vComponent<Unit> {

    setup = { _, _ ->
        val counter = ref(0)

        vRender {
            span {
                `class` = "d-flex flex-row"

                div {
                    +"+"
                    `class` = "btn btn-danger mr-4 ml-4"
                    on {
                        click { counter.value++ }
                    }
                }

                div {
                    +"${counter.value}"
                    `class` = "counter"
                }

                div {
                    +"-"
                    `class` = "btn btn-danger mr-4 ml-4"
                    addOnEvent("click") { counter.value-- }
                }

            }
        }
    }

    css {
        ".content" {
            width = LinearDimension("500px")
        }

        ".counter" {
            height = LinearDimension.fitContent
        }

        ".btn" {
        }
    }
}