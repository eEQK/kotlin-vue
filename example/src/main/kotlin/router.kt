import components.container
import views.binding
import views.binding2
import views.directives
import views.home
import wrapper.vRouter

val vRouter = vRouter {
    mode = "hash"
    vRoute {
        path = "/"
        component = container()

        childRoute {
            path = ""
            component = home()
        }

        childRoute {
            path = "binding"
            component = binding()
        }

        childRoute {
            path = "binding2"
            component = binding2()
        }

        childRoute {
            path = "directives"
            component = directives()
        }
    }
}