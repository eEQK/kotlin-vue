package utils

import kotlin.test.asserter

fun assertEqualsIgnoreCaseAndWhitespace(expected: String?, actual: String?, message: String? = null) {
    asserter.assertEquals(
        message,
        expected?.filterNot { it.isWhitespace() }?.toLowerCase(),
        actual?.filterNot { it.isWhitespace() }?.toLowerCase()
    )
}