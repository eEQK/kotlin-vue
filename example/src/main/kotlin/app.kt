import components.primaryHeader
import views.sideMenu
import wrapper.div
import wrapper.routerView
import wrapper.vComponent
import wrapper.vRender


fun app() = vComponent<Unit> {
    name = "app"
    setup = { _, _ ->
        vRender {
            div {
                primaryHeader().h()

                div {
                    `class` = "d-flex flex-row"
                    sideMenu().h { `class` = "sidebar" }

                    routerView {
                        name = "container"
                    }

                }
            }
        }
    }
}



