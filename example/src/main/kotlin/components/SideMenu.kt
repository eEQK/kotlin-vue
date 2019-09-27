package components

import components.side_menu.SideMenuGroup
import components.side_menu.SideMenuItem
import cssdsl.CssRuleSet
import kotlinx.css.Align
import kotlinx.css.Display
import kotlinx.css.FlexDirection
import kotlinx.css.alignItems
import kotlinx.css.display
import kotlinx.css.flexDirection
import wrapper.VComponent
import wrapper.VComponentBuilder
import wrapper.div
import wrapper.vRender

class SideMenu(builder: VComponentBuilder<Unit>? = null) : VComponent<Unit>(builder) {
    init {
        css { +stylesSideMenu }

        setup { _, _ ->
            vRender {
                div {
                    `class` = "side-menu"
                    +SideMenuItem {
                        props {
                            to = "home"
                            title = "Home"
                            icon = "home"
                        }
                    }
                    +SideMenuItem {
                        props {
                            to = "functionalComponents"
                            title = "Functional Components"
                            icon = "robot"
                        }
                    }
                    +SideMenuItem {
                        props {
                            to = "directives"
                            title = "Directives"
                            icon = "terminal"
                        }
                    }
                    +SideMenuItem {
                        props {
                            to = "reactiveApi"
                            title = "Reactive API"
                            icon = "cogs"
                        }
                    }
                    +SideMenuGroup {
                        props {
                            title = "Slots"
                            icon = "grip-lines"
                        }
                        slot {
                            div {
                                slot = "side-menu-items"
                                +SideMenuItem {
                                    props {
                                        to = "slots"
                                        title = "Slots"
                                        icon(arrayOf("fa", "grip-lines"))
                                    }
                                }
                                +SideMenuItem {
                                    props {
                                        to = "scopedSlots"
                                        title = "Scoped Slots"
                                        icon(arrayOf("fa", "sliders-h"))
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

private val stylesSideMenu: CssRuleSet = {
    ".side-menu" {
        display = Display.flex
        flexDirection = FlexDirection.column
        alignItems = Align.center
    }
}
