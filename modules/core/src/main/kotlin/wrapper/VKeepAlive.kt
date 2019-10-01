package wrapper

import external.vue.VNode

/**
 * https://vuejs.org/v2/api/#keep-alive
 */
class VKeepAlive {

    var include: Any? = null
    var exclude: Any? = null
    var max: Number? = null
}

fun VRender.keepAlive(render: (VRenderer<VKeepAlive, Any, Any>.() -> Unit)? = null): VNode {
    return render?.let {
        h("keep-alive", render, VKeepAlive())
    } ?: h("keep-alive")
}
