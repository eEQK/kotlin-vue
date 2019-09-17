package components

import wrapper.div
import wrapper.routerView
import wrapper.vComponent
import wrapper.vRender

fun container() = vComponent<Unit> {
    name = "users"

    setup = { _, _ ->
        vRender {
            div {
                routerView()
            }
        }
    }
}