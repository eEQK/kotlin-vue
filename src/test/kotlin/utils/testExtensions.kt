package utils

import kotlin.test.asserter

fun assertEqualsIgnoreWhitespace(expected: String?, actual: String?, message: String? = null) {
    asserter.assertEquals(
        message,
        expected?.filterNot { it.isWhitespace() },
        actual?.filterNot { it.isWhitespace() }
    )
}

fun assertEqualsIgnoreCase(expected: String?, actual: String?, message: String? = null) {
    asserter.assertEquals(
        message,
        expected?.toLowerCase(),
        actual?.toLowerCase()
    )
}