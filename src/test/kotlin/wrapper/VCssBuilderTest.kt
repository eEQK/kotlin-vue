package wrapper

import kotlinx.css.Color
import kotlinx.css.color
import utils.assertEqualsIgnoreCaseAndWhitespace
import kotlin.test.Test
import kotlin.test.assertEquals

internal typealias VCssRuleSet = VCssBuilder.() -> Unit

class VCssBuilderTest {

    @Test
    fun shouldReturnCorrectCssBlock() {
        val builder = VCssBuilder()
        val css = builder {
            ".test" {
                color = Color.blueViolet
            }
        }

        assertEquals(1, css.rules.size)
        assertEqualsIgnoreCaseAndWhitespace(
            ".test { color: blueviolet; }",
            css.toString()
        )
    }

    @Test
    fun shouldReturnCorrectNestedCssBlock() {
        val builder = VCssBuilder()
        val css = builder {
            ".test" {
                "> .test2" {
                    color = Color.peachPuff
                }
                color = Color.blueViolet
            }
        }

        assertEquals(1, css.rules.size)
        assertEqualsIgnoreCaseAndWhitespace(
            """
                .test { 
                    color: blueviolet; 
                    > .test2 { 
                        color: peachpuff; 
                    } 
                }
            """.trimIndent(),
            css.toString()
        )
    }

    @Test
    fun shouldReturnCorrectCssWithAddedExternalCssBuilder() {
        val builder = VCssBuilder()
        val externalCssBuilder: VCssRuleSet = {
            ".test"{
                color = Color.saddleBrown
                "> .test2" {
                    color = Color.blue
                }
            }
        }
        val css = builder { add(externalCssBuilder) }

        println(css.toString())
        assertEquals(1, css.rules.size)
        assertEqualsIgnoreCaseAndWhitespace(
            """
                .test { 
                    color: saddlebrown; 
                    > .test2 { 
                        color: blue; 
                    } 
                }
            """.trimIndent(),
            css.toString()
        )
    }

    @Test
    fun shouldReturnCorrectCssWithOwnAndAddedExternalCssBuilder() {
        val builder = VCssBuilder()
        val externalCssBuilder: VCssRuleSet = {
            ".test"{
                color = Color.saddleBrown
                "> .test2" {
                    color = Color.blue
                }
            }
        }
        val css = builder {
            add(externalCssBuilder)
            ".test3"{
                color = Color.aqua
                ".test4" {
                    color = Color.grey
                }
            }
        }

        println(css.toString())
        assertEquals(2, css.rules.size)
        assertEqualsIgnoreCaseAndWhitespace(
            """
                .test { 
                    color: saddlebrown; 
                    > .test2 { 
                        color: blue; 
                    } 
                }
                .test3 { 
                    color: aqua; 
                    .test4 { 
                        color: grey; 
                    } 
                }
            """.trimIndent(),
            css.toString()
        )
    }
}