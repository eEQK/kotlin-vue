package wrapper

import cssdsl.CssManager
import cssdsl.CssRuleSet
import external.composition_api.SetupContext
import external.composition_api.SetupFunction
import kotlinext.js.jsObject

typealias VComponentBuilder<P> = VComponent<P>.() -> Unit

fun <P : Any> vComponent(builder: VComponentBuilder<P> = {}): VComponent<P> =
    VComponent(null, builder)

fun vComponent(builder: VComponentBuilder<Unit> = {}): VComponent<Unit> =
    VComponent(null, builder)

open class VComponent<P : Any>(
    renderProps: P? = null,
    builder: VComponentBuilder<P> = {}
) : VNodeDataBuilder<P, Unit, Unit>() {

    var propDefs: VPropDefs? = null
    var setupFunction: SetupFunction<P>? = null

    init {
        builder?.let { apply(it) }

        propsBuilder?.let {
            props = renderProps?.apply(it) ?: jsObject(it)
        }
    }

    // TODO: what if there will be two components inn different packages that are called the same?
    fun css(builder: CssRuleSet) =
        CssManager.append(builder, this::class.simpleName)

    fun propData(builder: PropData.() -> Unit) {
        propDefs = buildPropDefs(builder)
    }

    fun setup(value: SetupFunction<P>) {
        setupFunction = value
    }

    fun component(): VComponentOptions = jsObject {
        name = VComponent::class.simpleName
        props = propDefs
        setup = setupFunction
    }

    // TODO: refactor slot
    fun slot(VRender: VRender.() -> Unit) {
        child(VRenderer<Unit, Unit, Unit>().apply(VRender).children.first())
    }

    fun <T> getRef(name: String, ctx: SetupContext): T? =
        ctx.refs?.get(name).unsafeCast<T?>()
}

class VComponentFuncBuilder<P : Any>(renderProps: P? = null) : VComponent<P>(renderProps = renderProps) {
    var name: String? = null
}