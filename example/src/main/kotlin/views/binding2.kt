package views

import external.composition_api.ref
import org.w3c.dom.HTMLInputElement
import wrapper.div
import wrapper.input
import wrapper.vComponent
import wrapper.vRender

fun binding2() = vComponent<Unit> {
    setup = { _, _ ->
        val state = ref("")

        vRender {
            div {

                input {
                    on {
                        input {
                            state.value = it.target.unsafeCast<HTMLInputElement>().value
                        }
                    }
                }

                div {
                    +state.value
                }

            }
        }
    }
}
