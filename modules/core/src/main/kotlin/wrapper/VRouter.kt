@file:Suppress("unused")

package wrapper

import external.vue.Location
import external.vue.NavigationGuard
import external.vue.PathToRegexpOptions
import external.vue.Position
import external.vue.PositionResult
import external.vue.Route
import external.vue.RouteConfig
import external.vue.RoutePropsFunction
import external.vue.RouterOptions
import external.vue.VNode
import external.vue.VueRouter
import kotlinext.js.JsObject
import kotlinext.js.jsObject
import kotlin.js.Promise

fun vRouter(builder: VRouterOptions.() -> Unit): VueRouter = VueRouter(VRouterOptions().apply(builder))

class VRouterOptions : RouterOptions {

    private val childList = arrayListOf<VRouteConfig>()

    fun vRoute(builder: VRouteConfig.() -> Unit) {
        val config = VRouteConfig().apply(builder)
        childList.add(config)
        routes = childList.toTypedArray()
    }

    fun parseQuery(callback: (query: String) -> Any) {
        parseQuery = callback
    }

    fun stringifyQuery(callback: (query: Any) -> String) {
        stringifyQuery = callback
    }

    fun scrollBehavior(callback: (to: Route, from: Route, savedPosition: Position?) -> Promise<PositionResult>) {
        scrollBehavior = callback
    }

    fun scrollBehavior(callback: (to: Route, from: Route, savedPosition: Position?) -> PositionResult) {
        scrollBehavior = callback
    }
}

class VRouteConfig : RouteConfig {

    private val childList = arrayListOf<VRouteConfig>()

    fun childRoute(builder: VRouteConfig.() -> Unit) {
        val config = VRouteConfig().apply(builder)
        childList.add(config)
        children = childList.toTypedArray()
    }

    fun beforeEnter(callback: NavigationGuard) {
        beforeEnter = callback
    }

    fun pathToRegexpOptions(builder: PathToRegexpOptions.() -> Unit) {
        pathToRegexpOptions = jsObject(builder)
    }

    fun props(value: Boolean) {
        props = value
    }

    fun props(value: JsObject) {
        props = value
    }

    fun props(value: RoutePropsFunction) {
        props = value
    }
}

class RouteLocation : Location

/**
 * https://router.vuejs.org/api/#router-view-props
 */
class RouterViewProps {

    var name: String? = undefined
}

/**
 * https://router.vuejs.org/api/#router-link-props
 */
class RouterLinkProps {

    var to: Any? = undefined
    var replace: Boolean? = undefined
    var append: Boolean? = undefined
    var tag: String? = undefined
    var activeClass: String? = undefined
    var exact: Boolean? = undefined
    var event: Any? = undefined

    fun to(value: String) {
        to = value
    }

    fun to(builder: RouteLocation.() -> Unit) {
        to = RouteLocation().apply(builder)
    }

    fun event(value: String) {
        event = value
    }

    fun event(value: Array<String>) {
        event = value
    }

    var exactActiveClass: String? = undefined
}

fun VRender.routerView(render: (VRenderer<RouterViewProps, Any, Any>.() -> Unit)? = null): VNode {
    return render?.let {
        h("router-view", render, RouterViewProps())
    } ?: h("router-view")
}

fun VRender.routerLink(builder: VRenderer<RouterLinkProps, Any, Any>.() -> Unit): VNode =
    h("router-link", builder, RouterLinkProps())

