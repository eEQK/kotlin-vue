package components

import components.side_menu.SideMenuGroup
import components.side_menu.SideMenuItem
import cssdsl.CssRuleSet
import kotlinx.css.*
import wrapper.VComponent
import wrapper.div
import wrapper.vRender

class SideMenu() : VComponent<Unit>() {
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
                            to = ""
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
