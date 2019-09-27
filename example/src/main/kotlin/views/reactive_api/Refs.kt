package views.reactive_api

import external.composition_api.ref
import kotlinx.css.LinearDimension
import kotlinx.css.label
import kotlinx.css.marginTop
import kotlinx.css.maxWidth
import org.w3c.dom.HTMLInputElement
import wrapper.VComponent
import wrapper.div
import wrapper.form
import wrapper.input
import wrapper.label
import wrapper.pre
import wrapper.vRender

class RefsExample : VComponent<Unit>() {
    init {
        css {
            ".form-col"{
                maxWidth = LinearDimension("16rem")
            }
            label {
                marginTop = LinearDimension("1rem")
            }
        }

        setup { _, _ ->
            val state = ref("")

            vRender {
                form {
                    div {
                        `class` = "form-col"

                        label {
                            +"Some Input"
                            input {
                                domProps {
                                    value = state.value
                                }
                                on {
                                    input {
                                        state.value = it.target.unsafeCast<HTMLInputElement>().value
                                    }
                                }
                            }
                        }
                    }
                    div {
                        `class` = "form-col"

                        div {
                            pre {
                                +JSON.stringify(state, null, 2)
                            }
                        }
                    }
                }
            }
        }
    }
}
