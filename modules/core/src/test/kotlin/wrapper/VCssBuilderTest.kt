package wrapper

import kotlinx.css.Color
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
    fun shouldReturnCorrectCssWithAddedExternalCssBuilder() {
        val builder = VCssBuilder()
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