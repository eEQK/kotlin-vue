package wrapper

import external.vue.DirectiveFunction
import external.vue.DirectiveOptions
import external.vue.VNodeDirective

class VDirective : VNodeDirective

class VDirectivesBuilder : DirectiveOptions {

    val vDirectives = mutableListOf<VDirective>()

    operator fun String.invoke(block: VDirective.() -> Unit): List<VDirective> {
        val directive = VDirective().apply(block)
        directive.name = this
        vDirectives.add(directive)
        return vDirectives
    }

    fun bind(directiveFunction: DirectiveFunction) {
        bind = directiveFunction
    }

    fun inserted(directiveFunction: DirectiveFunction) {
        inserted = directiveFunction
    }

    fun update(directiveFunction: DirectiveFunction) {
        update = directiveFunction
    }

    fun componentUpdated(directiveFunction: DirectiveFunction) {
        componentUpdated = directiveFunction
    }

    fun unbind(directiveFunction: DirectiveFunction) {
        unbind = directiveFunction
    }
}

fun vDirective(builder: VDirectivesBuilder.() -> Unit) =
    VDirectivesBuilder().apply(builder)


