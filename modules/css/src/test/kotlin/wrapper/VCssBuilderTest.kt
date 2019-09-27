package cssdsl

import kotlinx.css.Color
import kotlinx.css.color
import utils.assertEqualsIgnoreCaseAndWhitespace
import kotlin.test.Test
import kotlin.test.assertEquals

internal typealias VCssRuleSet = CssBuilder.() -> Unit

class VCssBuilderTest {

    @Test
    fun shouldReturnCorrectCssBlock() {
        val builder = CssBuilder()
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
    fun shouldReturnCorrectCssWithAddedExternalCssBuilder() {
        val builder = CssBuilder()
        val externalCssBuilder: VCssRuleSet = {
            ".test"{
                color = Color.saddleBrown
            }
        }
        val css = builder { +externalCssBuilder }

        assertEquals(1, css.rules.size)
        assertEqualsIgnoreCaseAndWhitespace(
            ".test { color: saddlebrown; }",
            css.toString()
        )
    }
}