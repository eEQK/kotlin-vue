@file:Suppress("unused")

package wrapper

import cssdsl.CssRule
import cssdsl.CssRulesBlock
import external.vue.*

open class VNodeDataBuilder<P, A, D> : VNodeData<P, A, D> {

    var children: ArrayList<VNode> = arrayListOf()
    var propsBuilder: (P.() -> Unit)? = null
    var attributeBuilder: (A.() -> Unit)? = null
    var domPropsBuilder: (D.() -> Unit)? = null

    operator fun String.unaryPlus() {
        children.add(this.unsafeCast<VNode>())
    }

    fun child(child: VNode) {
        children.add(child)
    }

    fun props(builder: P.() -> Unit) {
        propsBuilder = builder
    }

    fun attrs(builder: A.() -> Unit) {
        attributeBuilder = builder
    }

    fun domProps(builder: D.() -> Unit) {
        domPropsBuilder = builder
    }

    fun style(builder: CssRulesBlock) {
        val vCssRule = CssRule.of(builder)
        style = vCssRule.toString()
    }

    fun directives(builder: VDirectivesBuilder.() -> Unit) {
        directives = VDirectivesBuilder().apply(builder).vDirectives.toTypedArray()
    }

    fun scopedSlots(builder: VScopedSlotsBuilder.() -> Unit) {
        VScopedSlotsBuilder().apply(builder)
    }

    fun on(builder: VOnEvents.() -> Unit) {
        VOnEvents().apply(builder)
    }

    fun nativeOn(builder: VOnEvents.() -> Unit) {
        VOnEvents().apply(builder)
    }

    fun <R> addOnEvent(eventName: String, callback: EventCallback<R>) {
        on ?: run { on = VOnEvents() }
        on!![eventName] = callback
    }

    fun <R> addOnEvents(eventName: String, builder: EventCallbacksBuilder<R>) {
        on ?: run { on = VOnEvents() }
        on!![eventName] = arrayListOf<EventCallback<R>>().apply(builder).toTypedArray()
    }

    inner class VScopedSlotsBuilder {
        operator fun <Props> String.invoke(scopedSlot: ScopedSlot<Props>) {
            scopedSlots ?: run { scopedSlots = VScopedSlots() }
            scopedSlots!![this] = scopedSlot
        }

        operator fun String.invoke(normalizedScopedSlot: NormalizedScopedSlot) {
            scopedSlots ?: run { scopedSlots = VScopedSlots() }
            scopedSlots!![this] = normalizedScopedSlot
        }
    }

    inner class VOnEvents : VWebEvents() {

        operator fun <R> String.invoke(callback: EventCallback<R>) = addOnEvent(this, callback)

        fun custom(eventName: String, builder: EventCallbacksBuilder<Any>) = addOnEvents(eventName, builder)
    }

}

