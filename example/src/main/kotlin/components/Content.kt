package components

import wrapper.VComponent
import wrapper.div
import wrapper.routerView
import wrapper.vRender

class Content : VComponent<Unit>() {
    init {
        setup { _, _ ->
            vRender {
                div {
                    `class` = "main-content"
                    routerView()
                }
            }
        }
    }
}