@file:Suppress("unused")

package wrapper

import external.composition_api.createElement
import external.vue.VNode
import external.vue.invoke
import kotlinext.js.jsObject
import kotlinx.html.A
import kotlinx.html.ABBR
import kotlinx.html.ADDRESS
import kotlinx.html.AREA
import kotlinx.html.ARTICLE
import kotlinx.html.ASIDE
import kotlinx.html.AUDIO
import kotlinx.html.B
import kotlinx.html.BASE
import kotlinx.html.BDI
import kotlinx.html.BDO
import kotlinx.html.BLOCKQUOTE
import kotlinx.html.BODY
import kotlinx.html.BR
import kotlinx.html.BUTTON
import kotlinx.html.CANVAS
import kotlinx.html.CAPTION
import kotlinx.html.CITE
import kotlinx.html.CODE
import kotlinx.html.COL
import kotlinx.html.COLGROUP
import kotlinx.html.DATALIST
import kotlinx.html.DD
import kotlinx.html.DEL
import kotlinx.html.DETAILS
import kotlinx.html.DFN
import kotlinx.html.DIALOG
import kotlinx.html.DIV
import kotlinx.html.DL
import kotlinx.html.DT
import kotlinx.html.EM
import kotlinx.html.EMBED
import kotlinx.html.Entities
import kotlinx.html.FIELDSET
import kotlinx.html.FIGCAPTION
import kotlinx.html.FIGURE
import kotlinx.html.FOOTER
import kotlinx.html.FORM
import kotlinx.html.H1
import kotlinx.html.H2
import kotlinx.html.H3
import kotlinx.html.H4
import kotlinx.html.H5
import kotlinx.html.H6
import kotlinx.html.HEAD
import kotlinx.html.HEADER
import kotlinx.html.HGROUP
import kotlinx.html.HR
import kotlinx.html.HTML
import kotlinx.html.HTMLTag
import kotlinx.html.I
import kotlinx.html.IFRAME
import kotlinx.html.IMG
import kotlinx.html.INPUT
import kotlinx.html.INS
import kotlinx.html.KBD
import kotlinx.html.LABEL
import kotlinx.html.LEGEND
import kotlinx.html.LI
import kotlinx.html.LINK
import kotlinx.html.MAP
import kotlinx.html.MARK
import kotlinx.html.META
import kotlinx.html.METER
import kotlinx.html.NAV
import kotlinx.html.NOSCRIPT
import kotlinx.html.OBJECT
import kotlinx.html.OL
import kotlinx.html.OPTGROUP
import kotlinx.html.OPTION
import kotlinx.html.OUTPUT
import kotlinx.html.P
import kotlinx.html.PARAM
import kotlinx.html.PRE
import kotlinx.html.PROGRESS
import kotlinx.html.Q
import kotlinx.html.RP
import kotlinx.html.RT
import kotlinx.html.RUBY
import kotlinx.html.SAMP
import kotlinx.html.SCRIPT
import kotlinx.html.SECTION
import kotlinx.html.SELECT
import kotlinx.html.SMALL
import kotlinx.html.SOURCE
import kotlinx.html.SPAN
import kotlinx.html.STRONG
import kotlinx.html.STYLE
import kotlinx.html.SUB
import kotlinx.html.SUP
import kotlinx.html.TABLE
import kotlinx.html.TBODY
import kotlinx.html.TD
import kotlinx.html.TEXTAREA
import kotlinx.html.TFOOT
import kotlinx.html.TH
import kotlinx.html.THEAD
import kotlinx.html.TIME
import kotlinx.html.TITLE
import kotlinx.html.TR
import kotlinx.html.Tag
import kotlinx.html.TagConsumer
import kotlinx.html.UL
import kotlinx.html.Unsafe
import kotlinx.html.VAR
import kotlinx.html.VIDEO
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.HTMLAreaElement
import org.w3c.dom.HTMLBRElement
import org.w3c.dom.HTMLBaseElement
import org.w3c.dom.HTMLBodyElement
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLCanvasElement
import org.w3c.dom.HTMLDListElement
import org.w3c.dom.HTMLDataListElement
import org.w3c.dom.HTMLDetailsElement
import org.w3c.dom.HTMLDialogElement
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLEmbedElement
import org.w3c.dom.HTMLFieldSetElement
import org.w3c.dom.HTMLFormElement
import org.w3c.dom.HTMLHRElement
import org.w3c.dom.HTMLHeadElement
import org.w3c.dom.HTMLHeadingElement
import org.w3c.dom.HTMLHtmlElement
import org.w3c.dom.HTMLIFrameElement
import org.w3c.dom.HTMLImageElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLLIElement
import org.w3c.dom.HTMLLabelElement
import org.w3c.dom.HTMLLegendElement
import org.w3c.dom.HTMLLinkElement
import org.w3c.dom.HTMLMapElement
import org.w3c.dom.HTMLMetaElement
import org.w3c.dom.HTMLMeterElement
import org.w3c.dom.HTMLModElement
import org.w3c.dom.HTMLOListElement
import org.w3c.dom.HTMLObjectElement
import org.w3c.dom.HTMLOptGroupElement
import org.w3c.dom.HTMLOptionElement
import org.w3c.dom.HTMLOutputElement
import org.w3c.dom.HTMLParagraphElement
import org.w3c.dom.HTMLParamElement
import org.w3c.dom.HTMLPreElement
import org.w3c.dom.HTMLProgressElement
import org.w3c.dom.HTMLQuoteElement
import org.w3c.dom.HTMLScriptElement
import org.w3c.dom.HTMLSelectElement
import org.w3c.dom.HTMLSourceElement
import org.w3c.dom.HTMLSpanElement
import org.w3c.dom.HTMLTableCaptionElement
import org.w3c.dom.HTMLTableCellElement
import org.w3c.dom.HTMLTableColElement
import org.w3c.dom.HTMLTableElement
import org.w3c.dom.HTMLTableRowElement
import org.w3c.dom.HTMLTableSectionElement
import org.w3c.dom.HTMLTextAreaElement
import org.w3c.dom.HTMLTimeElement
import org.w3c.dom.HTMLTitleElement
import org.w3c.dom.HTMLUListElement
import org.w3c.dom.HTMLVideoElement
import org.w3c.dom.events.Event

fun <A : HTMLTag, D : HTMLElement> VBuilder.tag(
    tag: String,
    attrs: A,
    render: VRenderer<Unit, A, D>.() -> Unit
): VNode {
    val vNodeData = VRenderer<Unit, A, D>().apply(render)

    vNodeData.attributeBuilder?.let {
        if (vNodeData.attrs == null) {
            vNodeData.attrs = jsObject { }
        }
        attrs.apply(it).attributesEntries.forEach { attr ->
            vNodeData.attrs.asDynamic()[attr.key] = attr.value
        }
    }
    vNodeData.domPropsBuilder?.let { vNodeData.domProps = jsObject(it) }

    val vNode = createElement(tag, vNodeData, vNodeData.children.toTypedArray())
    child(vNode)
    return vNode
}

fun VRender.a(render: VRenderer<Unit, A, HTMLAnchorElement>.() -> Unit): VNode =
    tag("a", A(mutableMapOf(), consumer), render)

fun VRender.abbr(render: VRenderer<Unit, ABBR, HTMLElement>.() -> Unit): VNode =
    tag("abbr", ABBR(mutableMapOf(), consumer), render)

fun VRender.address(render: VRenderer<Unit, ADDRESS, HTMLElement>.() -> Unit): VNode =
    tag("address", ADDRESS(mutableMapOf(), consumer), render)

fun VRender.area(render: VRenderer<Unit, AREA, HTMLAreaElement>.() -> Unit): VNode =
    tag("area", AREA(mutableMapOf(), consumer), render)

fun VRender.article(render: VRenderer<Unit, ARTICLE, HTMLElement>.() -> Unit): VNode =
    tag("article", ARTICLE(mutableMapOf(), consumer), render)

fun VRender.aside(render: VRenderer<Unit, ASIDE, HTMLElement>.() -> Unit): VNode =
    tag("aside", ASIDE(mutableMapOf(), consumer), render)

fun VRender.audio(render: VRenderer<Unit, AUDIO, HTMLElement>.() -> Unit): VNode =
    tag("audio", AUDIO(mutableMapOf(), consumer), render)

fun VRender.b(render: VRenderer<Unit, B, HTMLElement>.() -> Unit): VNode =
    tag("b", B(mutableMapOf(), consumer), render)

fun VRender.base(render: VRenderer<Unit, BASE, HTMLBaseElement>.() -> Unit): VNode =
    tag("base", BASE(mutableMapOf(), consumer), render)

fun VRender.bdi(render: VRenderer<Unit, BDI, HTMLElement>.() -> Unit): VNode =
    tag("bdi", BDI(mutableMapOf(), consumer), render)

fun VRender.bdo(render: VRenderer<Unit, BDO, HTMLElement>.() -> Unit): VNode =
    tag("bdo", BDO(mutableMapOf(), consumer), render)

fun VRender.blockQuote(render: VRenderer<Unit, BLOCKQUOTE, HTMLQuoteElement>.() -> Unit): VNode =
    tag("blockQuote", BLOCKQUOTE(mutableMapOf(), consumer), render)

fun VRender.body(render: VRenderer<Unit, BODY, HTMLBodyElement>.() -> Unit): VNode =
    tag("body", BODY(mutableMapOf(), consumer), render)

fun VRender.br(render: VRenderer<Unit, BR, HTMLBRElement>.() -> Unit): VNode =
    tag("br", BR(mutableMapOf(), consumer), render)

fun VRender.button(render: VRenderer<Unit, BUTTON, HTMLButtonElement>.() -> Unit): VNode =
    tag("button", BUTTON(mutableMapOf(), consumer), render)

fun VRender.canvas(render: VRenderer<Unit, CANVAS, HTMLCanvasElement>.() -> Unit): VNode =
    tag("canvas", CANVAS(mutableMapOf(), consumer), render)

fun VRender.caption(render: VRenderer<Unit, CAPTION, HTMLTableCaptionElement>.() -> Unit): VNode =
    tag("caption", CAPTION(mutableMapOf(), consumer), render)

fun VRender.cite(render: VRenderer<Unit, CITE, HTMLElement>.() -> Unit): VNode =
    tag("cite", CITE(mutableMapOf(), consumer), render)

fun VRender.code(render: VRenderer<Unit, CODE, HTMLElement>.() -> Unit): VNode =
    tag("code", CODE(mutableMapOf(), consumer), render)

fun VRender.col(render: VRenderer<Unit, COL, HTMLTableColElement>.() -> Unit): VNode =
    tag("col", COL(mutableMapOf(), consumer), render)

fun VRender.colGroup(render: VRenderer<Unit, COLGROUP, HTMLTableColElement>.() -> Unit): VNode =
    tag("colGroup", COLGROUP(mutableMapOf(), consumer), render)

fun VRender.dataList(render: VRenderer<Unit, DATALIST, HTMLDataListElement>.() -> Unit): VNode =
    tag("dataList", DATALIST(mutableMapOf(), consumer), render)

fun VRender.dd(render: VRenderer<Unit, DD, HTMLElement>.() -> Unit): VNode =
    tag("dd", DD(mutableMapOf(), consumer), render)

fun VRender.del(render: VRenderer<Unit, DEL, HTMLModElement>.() -> Unit): VNode =
    tag("del", DEL(mutableMapOf(), consumer), render)

fun VRender.details(render: VRenderer<Unit, DETAILS, HTMLDetailsElement>.() -> Unit): VNode =
    tag("details", DETAILS(mutableMapOf(), consumer), render)

fun VRender.dfn(render: VRenderer<Unit, DFN, HTMLElement>.() -> Unit): VNode =
    tag("dfn", DFN(mutableMapOf(), consumer), render)

fun VRender.dialog(render: VRenderer<Unit, DIALOG, HTMLDialogElement>.() -> Unit): VNode =
    tag("dialog", DIALOG(mutableMapOf(), consumer), render)

fun VRender.div(render: VRenderer<Unit, DIV, HTMLDivElement>.() -> Unit): VNode =
    tag("div", DIV(mutableMapOf(), consumer), render)

fun VRender.dl(render: VRenderer<Unit, DL, HTMLDListElement>.() -> Unit): VNode =
    tag("dl", DL(mutableMapOf(), consumer), render)

fun VRender.dt(render: VRenderer<Unit, DT, HTMLElement>.() -> Unit): VNode =
    tag("dt", DT(mutableMapOf(), consumer), render)

fun VRender.em(render: VRenderer<Unit, EM, HTMLElement>.() -> Unit): VNode =
    tag("em", EM(mutableMapOf(), consumer), render)

fun VRender.embed(render: VRenderer<Unit, EMBED, HTMLEmbedElement>.() -> Unit): VNode =
    tag("embed", EMBED(mutableMapOf(), consumer), render)

fun VRender.fieldSet(render: VRenderer<Unit, FIELDSET, HTMLFieldSetElement>.() -> Unit): VNode =
    tag("fieldSet", FIELDSET(mutableMapOf(), consumer), render)

fun VRender.figcaption(render: VRenderer<Unit, FIGCAPTION, HTMLElement>.() -> Unit): VNode =
    tag("figcaption", FIGCAPTION(mutableMapOf(), consumer), render)

fun VRender.figure(render: VRenderer<Unit, FIGURE, HTMLElement>.() -> Unit): VNode =
    tag("figure", FIGURE(mutableMapOf(), consumer), render)

fun VRender.footer(render: VRenderer<Unit, FOOTER, HTMLElement>.() -> Unit): VNode =
    tag("footer", FOOTER(mutableMapOf(), consumer), render)

fun VRender.form(render: VRenderer<Unit, FORM, HTMLFormElement>.() -> Unit): VNode =
    tag("form", FORM(mutableMapOf(), consumer), render)

fun VRender.h1(render: VRenderer<Unit, H1, HTMLHeadingElement>.() -> Unit): VNode =
    tag("h1", H1(mutableMapOf(), consumer), render)

fun VRender.h2(render: VRenderer<Unit, H2, HTMLHeadingElement>.() -> Unit): VNode =
    tag("h2", H2(mutableMapOf(), consumer), render)

fun VRender.h3(render: VRenderer<Unit, H3, HTMLHeadingElement>.() -> Unit): VNode =
    tag("h3", H3(mutableMapOf(), consumer), render)

fun VRender.h4(render: VRenderer<Unit, H4, HTMLHeadingElement>.() -> Unit): VNode =
    tag("h4", H4(mutableMapOf(), consumer), render)

fun VRender.h5(render: VRenderer<Unit, H5, HTMLHeadingElement>.() -> Unit): VNode =
    tag("h5", H5(mutableMapOf(), consumer), render)

fun VRender.h6(render: VRenderer<Unit, H6, HTMLHeadingElement>.() -> Unit): VNode =
    tag("h6", H6(mutableMapOf(), consumer), render)

fun VRender.head(render: VRenderer<Unit, HEAD, HTMLHeadElement>.() -> Unit): VNode =
    tag("head", HEAD(mutableMapOf(), consumer), render)

fun VRender.header(render: VRenderer<Unit, HEADER, HTMLElement>.() -> Unit): VNode =
    tag("header", HEADER(mutableMapOf(), consumer), render)

fun VRender.hGroup(render: VRenderer<Unit, HGROUP, HTMLElement>.() -> Unit): VNode =
    tag("hGroup", HGROUP(mutableMapOf(), consumer), render)

fun VRender.hr(render: VRenderer<Unit, HR, HTMLHRElement>.() -> Unit): VNode =
    tag("hr", HR(mutableMapOf(), consumer), render)

fun VRender.html(render: VRenderer<Unit, HTML, HTMLHtmlElement>.() -> Unit): VNode =
    tag("html", HTML(mutableMapOf(), consumer), render)

fun VRender.i(render: VRenderer<Unit, I, HTMLElement>.() -> Unit): VNode =
    tag("i", I(mutableMapOf(), consumer), render)

fun VRender.iframe(render: VRenderer<Unit, IFRAME, HTMLIFrameElement>.() -> Unit): VNode =
    tag("iframe", IFRAME(mutableMapOf(), consumer), render)

fun VRender.img(render: VRenderer<Unit, IMG, HTMLImageElement>.() -> Unit): VNode =
    tag("img", IMG(mutableMapOf(), consumer), render)

fun VRender.input(render: VRenderer<Unit, INPUT, HTMLInputElement>.() -> Unit): VNode =
    tag("input", INPUT(mutableMapOf(), consumer), render)

fun VRender.ins(render: VRenderer<Unit, INS, HTMLModElement>.() -> Unit): VNode =
    tag("ins", INS(mutableMapOf(), consumer), render)

fun VRender.kbd(render: VRenderer<Unit, KBD, HTMLElement>.() -> Unit): VNode =
    tag("kbd", KBD(mutableMapOf(), consumer), render)

fun VRender.label(render: VRenderer<Unit, LABEL, HTMLLabelElement>.() -> Unit): VNode =
    tag("label", LABEL(mutableMapOf(), consumer), render)

fun VRender.legend(render: VRenderer<Unit, LEGEND, HTMLLegendElement>.() -> Unit): VNode =
    tag("legend", LEGEND(mutableMapOf(), consumer), render)

fun VRender.li(render: VRenderer<Unit, LI, HTMLLIElement>.() -> Unit): VNode =
    tag("li", LI(mutableMapOf(), consumer), render)

fun VRender.link(render: VRenderer<Unit, LINK, HTMLLinkElement>.() -> Unit): VNode =
    tag("link", LINK(mutableMapOf(), consumer), render)

fun VRender.map(render: VRenderer<Unit, MAP, HTMLMapElement>.() -> Unit): VNode =
    tag("map", MAP(mutableMapOf(), consumer), render)

fun VRender.mark(render: VRenderer<Unit, MARK, HTMLElement>.() -> Unit): VNode =
    tag("mark", MARK(mutableMapOf(), consumer), render)

fun VRender.meta(render: VRenderer<Unit, META, HTMLMetaElement>.() -> Unit): VNode =
    tag("meta", META(mutableMapOf(), consumer), render)

fun VRender.meter(render: VRenderer<Unit, METER, HTMLMeterElement>.() -> Unit): VNode =
    tag("meter", METER(mutableMapOf(), consumer), render)

fun VRender.nav(render: VRenderer<Unit, NAV, HTMLElement>.() -> Unit): VNode =
    tag("nav", NAV(mutableMapOf(), consumer), render)

fun VRender.noScript(render: VRenderer<Unit, NOSCRIPT, HTMLElement>.() -> Unit): VNode =
    tag("noScript", NOSCRIPT(mutableMapOf(), consumer), render)

fun VRender.`object`(render: VRenderer<Unit, OBJECT, HTMLObjectElement>.() -> Unit): VNode =
    tag("object", OBJECT(mutableMapOf(), consumer), render)

fun VRender.ol(render: VRenderer<Unit, OL, HTMLOListElement>.() -> Unit): VNode =
    tag("ol", OL(mutableMapOf(), consumer), render)

fun VRender.optGroup(render: VRenderer<Unit, OPTGROUP, HTMLOptGroupElement>.() -> Unit): VNode =
    tag("optGroup", OPTGROUP(mutableMapOf(), consumer), render)

fun VRender.option(render: VRenderer<Unit, OPTION, HTMLOptionElement>.() -> Unit): VNode =
    tag("option", OPTION(mutableMapOf(), consumer), render)

fun VRender.output(render: VRenderer<Unit, OUTPUT, HTMLOutputElement>.() -> Unit): VNode =
    tag("output", OUTPUT(mutableMapOf(), consumer), render)

fun VRender.p(render: VRenderer<Unit, P, HTMLParagraphElement>.() -> Unit): VNode =
    tag("p", P(mutableMapOf(), consumer), render)

fun VRender.param(render: VRenderer<Unit, PARAM, HTMLParamElement>.() -> Unit): VNode =
    tag("param", PARAM(mutableMapOf(), consumer), render)

fun VRender.pre(render: VRenderer<Unit, PRE, HTMLPreElement>.() -> Unit): VNode =
    tag("pre", PRE(mutableMapOf(), consumer), render)

fun VRender.progress(render: VRenderer<Unit, PROGRESS, HTMLProgressElement>.() -> Unit): VNode =
    tag("progress", PROGRESS(mutableMapOf(), consumer), render)

fun VRender.q(render: VRenderer<Unit, Q, HTMLQuoteElement>.() -> Unit): VNode =
    tag("q", Q(mutableMapOf(), consumer), render)

fun VRender.rp(render: VRenderer<Unit, RP, HTMLElement>.() -> Unit): VNode =
    tag("rp", RP(mutableMapOf(), consumer), render)

fun VRender.rt(render: VRenderer<Unit, RT, HTMLElement>.() -> Unit): VNode =
    tag("rt", RT(mutableMapOf(), consumer), render)

fun VRender.ruby(render: VRenderer<Unit, RUBY, HTMLElement>.() -> Unit): VNode =
    tag("ruby", RUBY(mutableMapOf(), consumer), render)

fun VRender.samp(render: VRenderer<Unit, SAMP, HTMLElement>.() -> Unit): VNode =
    tag("samp", SAMP(mutableMapOf(), consumer), render)

fun VRender.script(render: VRenderer<Unit, SCRIPT, HTMLScriptElement>.() -> Unit): VNode =
    tag("script", SCRIPT(mutableMapOf(), consumer), render)

fun VRender.section(render: VRenderer<Unit, SECTION, HTMLElement>.() -> Unit): VNode =
    tag("section", SECTION(mutableMapOf(), consumer), render)

fun VRender.select(render: VRenderer<Unit, SELECT, HTMLSelectElement>.() -> Unit): VNode =
    tag("select", SELECT(mutableMapOf(), consumer), render)

fun VRender.small(render: VRenderer<Unit, SMALL, HTMLElement>.() -> Unit): VNode =
    tag("small", SMALL(mutableMapOf(), consumer), render)

fun VRender.source(render: VRenderer<Unit, SOURCE, HTMLSourceElement>.() -> Unit): VNode =
    tag("source", SOURCE(mutableMapOf(), consumer), render)

fun VRender.span(render: VRenderer<Unit, SPAN, HTMLSpanElement>.() -> Unit): VNode =
    tag("span", SPAN(mutableMapOf(), consumer), render)

fun VRender.strong(render: VRenderer<Unit, STRONG, HTMLSpanElement>.() -> Unit): VNode =
    tag("strong", STRONG(mutableMapOf(), consumer), render)

fun VRender.style(render: VRenderer<Unit, STYLE, HTMLSpanElement>.() -> Unit): VNode =
    tag("style", STYLE(mutableMapOf(), consumer), render)

fun VRender.sub(render: VRenderer<Unit, SUB, HTMLElement>.() -> Unit): VNode =
    tag("sub", SUB(mutableMapOf(), consumer), render)

fun VRender.sup(render: VRenderer<Unit, SUP, HTMLElement>.() -> Unit): VNode =
    tag("sup", SUP(mutableMapOf(), consumer), render)

fun VRender.table(render: VRenderer<Unit, TABLE, HTMLTableElement>.() -> Unit): VNode =
    tag("table", TABLE(mutableMapOf(), consumer), render)

fun VRender.tbody(render: VRenderer<Unit, TBODY, HTMLTableSectionElement>.() -> Unit): VNode =
    tag("tbody", TBODY(mutableMapOf(), consumer), render)

fun VRender.td(render: VRenderer<Unit, TD, HTMLTableCellElement>.() -> Unit): VNode =
    tag("td", TD(mutableMapOf(), consumer), render)

fun VRender.textArea(render: VRenderer<Unit, TEXTAREA, HTMLTextAreaElement>.() -> Unit): VNode =
    tag("textArea", TEXTAREA(mutableMapOf(), consumer), render)

fun VRender.tfoot(render: VRenderer<Unit, TFOOT, HTMLTableSectionElement>.() -> Unit): VNode =
    tag("tfoot", TFOOT(mutableMapOf(), consumer), render)

fun VRender.th(render: VRenderer<Unit, TH, HTMLTableCellElement>.() -> Unit): VNode =
    tag("th", TH(mutableMapOf(), consumer), render)

fun VRender.thead(render: VRenderer<Unit, THEAD, HTMLTableSectionElement>.() -> Unit): VNode =
    tag("thead", THEAD(mutableMapOf(), consumer), render)

fun VRender.time(render: VRenderer<Unit, TIME, HTMLTimeElement>.() -> Unit): VNode =
    tag("time", TIME(mutableMapOf(), consumer), render)

fun VRender.title(render: VRenderer<Unit, TITLE, HTMLTitleElement>.() -> Unit): VNode =
    tag("title", TITLE(mutableMapOf(), consumer), render)

fun VRender.tr(render: VRenderer<Unit, TR, HTMLTableRowElement>.() -> Unit): VNode =
    tag("tr", TR(mutableMapOf(), consumer), render)

fun VRender.ul(render: VRenderer<Unit, UL, HTMLUListElement>.() -> Unit): VNode =
    tag("ul", UL(mutableMapOf(), consumer), render)

fun VRender.`var`(render: VRenderer<Unit, VAR, HTMLElement>.() -> Unit): VNode =
    tag("var", VAR(mutableMapOf(), consumer), render)

fun VRender.video(render: VRenderer<Unit, VIDEO, HTMLVideoElement>.() -> Unit): VNode =
    tag("video", VIDEO(mutableMapOf(), consumer), render)

val consumer = object : TagConsumer<Unit> {
    override fun onTagAttributeChange(tag: Tag, attribute: String, value: String?) {
    }

    override fun onTagComment(content: CharSequence) {
    }

    override fun onTagContent(content: CharSequence) {
    }

    override fun onTagContentEntity(entity: Entities) {
    }

    override fun onTagContentUnsafe(block: Unsafe.() -> Unit) {
    }

    override fun onTagStart(tag: Tag) {
    }

    override fun onTagEnd(tag: Tag) {
    }

    override fun onTagEvent(tag: Tag, event: String, value: (Event) -> Unit) {
    }

    override fun finalize() {}
}
