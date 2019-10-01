import external.composition_api.inject
import external.composition_api.invoke
import external.composition_api.provide
import external.composition_api.symbol
import external.vue.VueRouter
import views.Directives
import views.Home
import views.reactive_api.Reactive
import views.reactive_api.ReactiveApi
import views.reactive_api.RefsExample
import views.slots.ScopedSlots
import views.slots.Slots
import wrapper.vRouter

val vRouter = vRouter {
    mode = "hash"

    vRoute {
        path = "/"
        name = "home"
        component = Home()
    }

    vRoute {
        path = "/directives"
        name = "directives"
        component = Directives()
    }

    vRoute {
        path = "/reactive_api"
        name = "reactiveApi"
        component = ReactiveApi()

        childRoute {
            path = "reactive"
            name = "reactive"
            component = Reactive()
        }

        childRoute {
            path = "refs"
            name = "ref"
            component = RefsExample()
        }
    }

    vRoute {
        path = "/slots"
        name = "slots"
        component = Slots()
    }

    vRoute {
        path = "/scoped_slots"
        name = "scopedSlots"
        component = ScopedSlots()
    }
}

val routerSymbol = symbol("Router")

fun provideRouter(providedRouter: VueRouter) {
    provide(routerSymbol, providedRouter)
}

fun useRouter(): VueRouter {
    val injectedRouter = inject<VueRouter>(routerSymbol)

    if (injectedRouter is VueRouter) {
        return injectedRouter
    } else {
        throw Error("[App] - No router was available for injection")
    }
}
