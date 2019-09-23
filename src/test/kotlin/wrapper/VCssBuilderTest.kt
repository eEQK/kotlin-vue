package wrapper

import kotlinx.css.Color
import kotlinx.css.color
import utils.assertEqualsIgnoreWhitespace
import kotlin.test.Test
import kotlin.test.assertEquals

class VCssBuilderTest {

    @Test
    fun shouldReturnCorrectCssBlock() {
        val builder = VCssBuilder()
        builder {
            ".test" {
                color = Color.blueViolet
            }
        }

        assertEquals(1, builder.rules.size)
        assertEqualsIgnoreWhitespace(
            ".test { color: blueviolet; }",
            builder.rules.first().toString()
        )
    }
}