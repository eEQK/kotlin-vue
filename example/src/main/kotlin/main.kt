import directives.initDirectives
import external.composition_api.VueCompositionApi
import external.vue.Vue
import external.vue.VueRouter
import kotlinext.js.jsObject
import wrapper.vRender
import kotlin.browser.document
import kotlin.browser.window


fun main() {
    initDirectives()

    Vue.use(VueCompositionApi)
    Vue.use(VueRouter)

    Vue.config.productionTip = false

    window.onload = {
        Vue(jsObject {
            router = vRouter
            render = {
                vRender {
                    app().h()
                }()
            }
        }).`$mount`(document.getElementById("app")!!)
    }
}

