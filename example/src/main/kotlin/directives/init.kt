package directives

import external.vue.Vue

fun initDirectives() {
    Vue.directive("custom-click", outsideOfNodeClick)
}
