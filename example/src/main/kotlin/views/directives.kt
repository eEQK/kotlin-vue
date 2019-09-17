package views

import external.composition_api.ref
import kotlinx.css.*
import wrapper.div
import wrapper.vComponent
import wrapper.vRender

fun directives() = vComponent<Unit> {
    setup = { _, _ ->

        val divBackground = ref(Color.red)
        val outsideOfNodeClick = {
            divBackground.value = Color.blue
        }

        vRender {
            div {
                div {

                    on {
                        click {
                            divBackground.value = Color.red
                        }
                    }

                    directives {
                        "custom-click" {
                            expression = outsideOfNodeClick
                        }
                    }

                    style {
                        height = LinearDimension("10rem")
                        width = LinearDimension("10rem")
                        backgroundColor = divBackground.value
                    }
                }
            }
        }
    }
}