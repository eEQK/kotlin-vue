package views.reactive_api

import external.composition_api.onActivated
import external.composition_api.onDeactivated
import external.composition_api.reactive
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

data class User(val id: Int) {
    var firstName: String = ""
    var lastName: String = ""
}

class Reactive : VComponent<Unit>() {
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

            onActivated {
                console.log("Activated")
            }
            onDeactivated {
                console.log("onDeactivated")
            }
            val user = reactive(User(1))

            vRender {
                form {
                    div {
                        `class` = "form-col"

                        label {
                            +"First Name"
                            input {
                                domProps {
                                    value = user.firstName
                                }
                                on {
                                    input {
                                        user.firstName = it.target.unsafeCast<HTMLInputElement>().value
                                    }
                                }
                            }
                        }

                        label {
                            +"Last Name"
                            input {
                                domProps {
                                    value = user.lastName
                                }
                                on {
                                    input {
                                        user.lastName = it.target.unsafeCast<HTMLInputElement>().value
                                    }
                                }
                            }
                        }
                    }
                    div {
                        `class` = "form-col"

                        div {
                            pre {
                                +JSON.stringify(user, null, 2)
                            }
                        }
                    }
                }
            }
        }
    }
}


